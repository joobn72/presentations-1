package com.codingthearchitecture.util;

import com.codingthearchitecture.domain.Presentation;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PresentationByReverseDateComparatorTests {

    private PresentationByReverseDateComparator comparator = new PresentationByReverseDateComparator();

    @Test
    public void test_compare_ReturnsMostRecentPresentationFirst() {
        Presentation p1 = new Presentation("p1");
        p1.setDate(new Date(1));
        Presentation p2 = new Presentation("p2");
        p2.setDate(new Date(2));

        assertEquals(1, comparator.compare(p1, p2));
        assertEquals(-1, comparator.compare(p2, p1));
    }

    @Test
    public void test_compare_DoesntFailWithNullPresentations() {
        Presentation p = new Presentation("p1");
        p.setDate(new Date(1));

        assertEquals(1, comparator.compare(p, null));
        assertEquals(-1, comparator.compare(null, p));
    }

    @Test
    public void test_compare_DoesntFailWithNullPresentationDates() {
        Presentation p1 = new Presentation("p1");
        p1.setDate(new Date(1));
        Presentation p2 = new Presentation("p2");
        p2.setDate(null);

        assertEquals(1, comparator.compare(p1, p2));
        assertEquals(-1, comparator.compare(p2, p1));
    }

}
