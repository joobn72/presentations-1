package com.codingthearchitecture.component.presentations;

import com.codingthearchitecture.domain.Presentation;

import java.util.List;

abstract class Dao {

    abstract List<Presentation> loadPresentations() throws Exception;

}
