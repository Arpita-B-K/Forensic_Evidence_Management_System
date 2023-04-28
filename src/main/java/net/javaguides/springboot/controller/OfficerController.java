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

import net.javaguides.springboot.entities.ForensicCase;
import net.javaguides.springboot.entities.Officer;
import net.javaguides.springboot.service.ForensicCaseService;
import net.javaguides.springboot.service.OfficerService;


@Controller
@RequestMapping("/officer")
public class OfficerController {
	@Autowired
	private OfficerService officerService;
	
	@Autowired
	private ForensicCaseService forensicCaseService;
	
	@GetMapping("/home2")
	public String dashboard(Model model,Principal principal) {
		
		return "home2";		
	}
	
//	add form controller
	@GetMapping("/open-officer")
	public String openOfficerForm(Model model) {
		model.addAttribute("listOfficer",officerService.getAllOfficer());
		return "open_officer_form";
	}
	@GetMapping("/new-officer")
	public String addOfficer(Model model) {
		Officer officer = new Officer();
		model.addAttribute("officer", officer);
		List<ForensicCase> cases = forensicCaseService.getAllCases();
		model.addAttribute("cases", cases);
		return "new_officer";
	}
	
	@PostMapping("/saveOfficer")
	public String saveOfficer(@ModelAttribute("officer") Officer officer) {
		// save employee to database
		officerService.saveOfficer(officer);
		return "redirect:/home2";
	}
	
	
	

	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		Officer officer = officerService.getOfficerByIdd(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("officer", officer);
		return  "update_officer";
	}
	
	
	@GetMapping("/deleteOfficer/{id}")
	public String deleteOfficer(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.officerService.deleteOfficerById(id);
		return "redirect:/home2";
	}

	
	

}
