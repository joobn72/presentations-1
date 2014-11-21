package com.codingthearchitecture.component.presentations;

import com.codingthearchitecture.domain.Country;
import com.codingthearchitecture.domain.Presentation;

import java.util.List;
import java.util.Set;

public interface PresentationsComponent {

    public Presentation getPresentation(String id);

    public List<Presentation> getPresentations();

    public Set<Country> getCountries();

    public void refresh();

}