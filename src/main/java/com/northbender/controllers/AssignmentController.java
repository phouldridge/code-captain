package com.northbender.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.northbender.domain.Assignment;

@Controller
public class AssignmentController {

	private Logger log = Logger.getLogger(AssignmentController.class);

	@RequestMapping("/assignment")
	String showAssignment(Model model) {
		model.addAttribute("assignment", new Assignment());
		return "assignment";
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submitCode(Assignment assignment, Model model) {
		log.info("Solution being submitted: " + assignment.getSolution());
		model.addAttribute("assignment", assignment);
		return "submit";
	}
}
