package com.codingthearchitecture.web.controller;

import com.codingthearchitecture.component.presentations.PresentationsComponent;
import org.springframework.beans.factory.annotation.Autowired;

class AbstractController {

    @Autowired
    protected PresentationsComponent presentationsComponent;

}
