package net.javaguides.springboot.controller;

import java.security.Principal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.entities.Suspect;
import net.javaguides.springboot.service.SuspectService;

import net.javaguides.springboot.service.ForensicCaseService;
import net.javaguides.springboot.entities.ForensicCase;
@Controller
@RequestMapping("/suspect")
public class SuspectController {
	
	@Autowired
	private SuspectService suspectService;
	
	@Autowired
	private ForensicCaseService forensicCaseService;
	
	
	@GetMapping("/home2")
	public String dashboard(Model model,Principal principal) {
		
		return "home2";		
	}
	
//	add form controller
	@GetMapping("/open-suspect")
	public String openSuspectForm(Model model) {
		model.addAttribute("listSuspect",suspectService.getAllSuspects());
		return "open_suspect_form";
	}
	@GetMapping("/new-suspect")
	public String addSuspect(Model model) {
		Suspect suspect = new Suspect();
		model.addAttribute("suspect", suspect);
		List<ForensicCase> cases = forensicCaseService.getAllCases();
		model.addAttribute("cases", cases);
		return "new_suspect";
	}
	
	@PostMapping("/saveSuspect")
	public String saveSuspect(@ModelAttribute("suspect") Suspect suspect) {
		// save employee to database
		suspectService.saveSuspect(suspect);
		return "redirect:/home2";
	}
	
	
	

	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		Suspect suspect = suspectService.getSuspectByIdd(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("suspect", suspect);
		return  "update_suspect";
	}
	
	
	@GetMapping("/deleteSuspect/{id}")
	public String deleteSuspect(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.suspectService.deleteSuspectById(id);
		return "redirect:/home2";
	}

}
