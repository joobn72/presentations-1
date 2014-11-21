package com.codingthearchitecture.component.presentations;

import com.codingthearchitecture.domain.Country;
import com.codingthearchitecture.domain.Presentation;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PresentationComponentUnitTests {

    private PresentationsComponent presentationsComponent;
    private MockPresentationsDao dao;

    @Test
    public void test_getCountries_ReturnsTheSetOfAllCountries() {
        dao = new MockPresentationsDao(
                createPresentation("1", "Jersey"),
                createPresentation("2", "Jersey"),
                createPresentation("3", "United States"),
                createPresentation("4", "China")
        );
        presentationsComponent = new PresentationsComponentImpl(dao);

        Set<Country> countries = presentationsComponent.getCountries();
        assertEquals(3, countries.size());
        Iterator<Country> it = countries.iterator();
        assertEquals("China", it.next().getName());
        assertEquals("Jersey", it.next().getName());
        assertEquals("United States", it.next().getName());
    }

    private Presentation createPresentation(String id, String country) {
        Presentation presentation = new Presentation(id);
        presentation.setCountry(new Country(country));
        presentation.setTitle("Some title");
        presentation.setDate(new Date());

        return presentation;
    }

}
