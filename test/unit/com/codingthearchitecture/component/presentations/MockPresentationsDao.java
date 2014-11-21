package com.codingthearchitecture.component.presentations;

import com.codingthearchitecture.domain.Presentation;

import java.util.Arrays;
import java.util.List;

class MockPresentationsDao extends Dao {

    private List<Presentation> presentations;

    MockPresentationsDao(Presentation... presentations) {
        this.presentations = Arrays.asList(presentations);
    }

    @Override
    List<Presentation> loadPresentations() throws Exception {
        return this.presentations;
    }
}
