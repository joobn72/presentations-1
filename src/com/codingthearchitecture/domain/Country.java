package com.codingthearchitecture.domain;

public class Country implements Comparable<Country> {

    private String name;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFlag() {
        return this.name.replace(" ", "-");
    }

    public int compareTo(Country country) {
        return this.name.compareTo(country.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (name != null ? !name.equals(country.name) : country.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return getName();
    }

}
