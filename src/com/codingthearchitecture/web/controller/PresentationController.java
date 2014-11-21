package com.codingthearchitecture.web.controller;

import com.codingthearchitecture.domain.Presentation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PresentationController extends AbstractController {

    @RequestMapping(value = "/{id:^[a-z-0-9]*$}", method = RequestMethod.GET)
   	public String viewPresentation(@PathVariable("id")String id, ModelMap model) {
        return viewPresentation(id, 1, model);
   	}

    @RequestMapping(value = "/{id:^[a-z-0-9]*$}/{slide:[\\d]+}", method = RequestMethod.GET)
   	public String viewPresentation(@PathVariable("id")String id, @PathVariable("slide")int slideNumber, ModelMap model) {
        Presentation presentation = presentationsComponent.getPresentation(id);
        if (presentation != null) {
            model.addAttribute("presentation", presentation);
            model.addAttribute("slideNumber", slideNumber);
            model.addAttribute("pageTitle", presentation.getTitle());

            return "presentation";
        } else {
            return "redirect:/";
        }
   	}

}
