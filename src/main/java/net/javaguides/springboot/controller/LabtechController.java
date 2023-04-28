package net.javaguides.springboot.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import net.javaguides.springboot.entities.Lab;
import net.javaguides.springboot.entities.Labtech;
import net.javaguides.springboot.service.LabService;
import net.javaguides.springboot.service.LabtechService;

@Controller
@RequestMapping("/labtech")
public class LabtechController {
	@Autowired
	private LabtechService labtechService;
	
	@Autowired
	private LabService labService;
	
	
	@GetMapping("/home2")
	public String dashboard(Model model,Principal principal) {
		
		return "home2";		
	}
	
//	add form controller
	@GetMapping("/open-labtech")
	public String openLabTechForm(Model model) {
		model.addAttribute("listLabtech",labtechService.getAllLabtech());
		return "open_labtech_form";
	}
	@GetMapping("/new-labtech")
	public String addLabtech(Model model) {
		Labtech labtech = new Labtech();
		model.addAttribute("labtech", labtech);
		List<Lab> lab = labService.getAllLab();
		model.addAttribute("lab", lab);
		return "new_labtech";
	}
	
	@PostMapping("/saveLabtech")
	public String saveLabtech(@ModelAttribute("labtech") Labtech labtech) {
		// save employee to database
		labtechService.saveLabtech(labtech);
		return "redirect:/home2";
	}
	
	
	

	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		Labtech labtech = labtechService.getLabtechByIdd(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("labtech", labtech);
		return  "update_labtech";
	}
	
	
	@GetMapping("/deleteLabtech/{id}")
	public String deleteLabtech(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.labtechService.deleteLabtechById(id);
		return "redirect:/home2";
	}
}
