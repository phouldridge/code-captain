package com.northbender.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.northbender.compiler.CodeCompiler;
import com.northbender.compiler.CompilationResult;
import com.northbender.domain.Assignment;
import com.northbender.services.AssignmentService;

@Controller
public class AssignmentController {

	private Logger log = Logger.getLogger(AssignmentController.class);
	private AssignmentService assignmentService;

	@Autowired
	public void setAssignmentService(AssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}

	@RequestMapping(value = "/assignments", method = RequestMethod.GET)
	String listAssignments(Model model) {
		model.addAttribute("assignments", assignmentService.listAll());
		return "assignments";
	}

	@RequestMapping("/assignment/{id}")
	public String showAssignment(@PathVariable Integer id, Model model) {
		model.addAttribute("assignment", assignmentService.getAssignmentById(id));
		return "assignmentdetail";
	}

	@RequestMapping("/assignment/edit/{id}")
	public String editAssignment(@PathVariable Integer id, Model model) {
		model.addAttribute("assignment", assignmentService.getAssignmentById(id));
		return "assignmentform";
	}

	@RequestMapping("/assignment/editor/{id}")
	public String editorAssignment(@PathVariable Integer id, Model model) {
		model.addAttribute("assignment", assignmentService.getAssignmentById(id));
		return "assignment";
	}

	@RequestMapping(value = "/assignment/save", method = RequestMethod.POST)
	String saveAssignment(Assignment assignment) {
		assignmentService.saveAssignment(assignment);
		return "redirect:/assignment/" + assignment.getId();
	}

	@RequestMapping("/assignment/new")
	public String newAssignment(Model model) {
		model.addAttribute("assignment", new Assignment());
		return "assignmentform";
	}

	@RequestMapping(value = "/assignment/result", method = RequestMethod.POST)
	String submitAssignment(Assignment assignment, Model model) {
		CodeCompiler compiler = new CodeCompiler();
		CompilationResult compilation = compiler.compile("org.acme.Test", assignment.getSolution());
		log.info( "assignment submitted:  \n" + assignment.getSolution() + "\nBuild: " + compilation.isSuccess() + "\nConsole: " + compilation.getResult());
		model.addAttribute("built", compilation.isSuccess());
		model.addAttribute("console", compilation.getResult());
		return "assignmentresult";
	}
}
