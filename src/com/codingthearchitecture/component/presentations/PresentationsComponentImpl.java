package com.codingthearchitecture.component.presentations;

import com.codingthearchitecture.domain.Country;
import com.codingthearchitecture.domain.Presentation;
import com.codingthearchitecture.util.PresentationByReverseDateComparator;

import java.util.*;
import java.util.stream.Collectors;

class PresentationsComponentImpl implements PresentationsComponent {

    private Dao dao;

    private Map<String,Presentation> presentationsById = new HashMap<>();
    private List<Presentation> presentationsByDate = new LinkedList<>();

    PresentationsComponentImpl(Dao dao) {
        this.dao = dao;
        this.refresh();
    }

    public Presentation getPresentation(String id) {
        if (presentationsById.containsKey(id)) {
            return presentationsById.get(id);
        } else {
            return null;
        }
    }

    public List<Presentation> getPresentations() {
        return new LinkedList<>(presentationsByDate);
    }

    @Override
    public Set<Country> getCountries() {
        return new TreeSet<>(
                getPresentations().stream()
                .map(Presentation::getCountry)
                .collect(Collectors.toSet()));

    }

    @Override
    public void refresh() {
        try {
            Map<String,Presentation> presentationsById = new HashMap<>();
            List<Presentation> presentationsByDate = new LinkedList<>();

            List<Presentation> presentations = dao.loadPresentations();
            for (Presentation presentation : presentations) {
                presentationsById.put(presentation.getId(), presentation);

                if (presentation.getDate() != null) {
                    presentationsByDate.add(presentation);
                }
            }

            Collections.sort(presentationsByDate, new PresentationByReverseDateComparator());

            this.presentationsById = presentationsById;
            this.presentationsByDate = presentationsByDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
