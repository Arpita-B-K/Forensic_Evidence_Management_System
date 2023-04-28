package net.javaguides.springboot.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.entities.Lab;
import net.javaguides.springboot.service.LabService;

@Controller
@RequestMapping("/lab")
public class LabController {
	@Autowired
	private LabService labService;
	
	
	@GetMapping("/home2")
	public String dashboard(Model model,Principal principal) {
		
		return "home2";		
	}
	
//	add form controller
	@GetMapping("/open-lab")
	public String openLabForm(Model model) {
		model.addAttribute("listLab",labService.getAllLab());
		return "open_lab_form";
	}
	@GetMapping("/new-lab")
	public String addLab(Model model) {
		Lab lab = new Lab();
		model.addAttribute("lab", lab);
		return "new_lab";
	}
	
	@PostMapping("/saveLab")
	public String saveLab(@ModelAttribute("lab") Lab lab) {
		// save employee to database
		labService.saveLab(lab);
		return "redirect:/home2";
	}
	
	
	

	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		Lab lab = labService.getLabByIdd(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("lab", lab);
		return  "update_lab";
	}
	
	
	@GetMapping("/deleteLab/{id}")
	public String deleteLab(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.labService.deleteLabById(id);
		return "redirect:/home2";
	}

}
