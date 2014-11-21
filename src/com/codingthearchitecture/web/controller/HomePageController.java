package com.codingthearchitecture.web.controller;

import com.codingthearchitecture.domain.Presentation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomePageController extends AbstractController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
   	public String showHomePage(ModelMap model) {
        List<Presentation> presentations = presentationsComponent.getPresentations();
        model.addAttribute("presentations", presentations);
        model.addAttribute("countries", presentationsComponent.getCountries());
        model.addAttribute("pageTitle", "Presentations");

        return "home";
   	}

}
