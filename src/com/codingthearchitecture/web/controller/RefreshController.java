package com.codingthearchitecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RefreshController extends AbstractController {

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
   	public String reloadPresentations() {
        try {
            presentationsComponent.refresh();
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }

        return "redirect:/";
   	}

}
