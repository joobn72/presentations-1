package com.codingthearchitecture.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CountryTests {

    @Test
    public void test_getFlag_ReturnsTheName_WhenThereAreNoSpaces() {
        Country country = new Country("Jersey");
        assertEquals("Jersey", country.getFlag());
    }

    @Test
    public void test_getFlag_ReturnsTheNameWithoutSpaces_WhenThereAreSomeSpaces() {
        Country country = new Country("United Kingdom");
        assertEquals("United-Kingdom", country.getFlag());
    }

    @Test
    public void test_compare_ComparesCountriesByNameAlphabetically() {
        Country jersey = new Country("Jersey");
        Country guernsey = new Country("Guernsey");

        assertTrue(guernsey.compareTo(jersey) < 1);
        assertTrue(jersey.compareTo(guernsey) > 1);
    }

}
