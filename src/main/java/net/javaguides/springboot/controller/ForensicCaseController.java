package net.javaguides.springboot.controller;
import net.javaguides.springboot.service.ForensicCaseService;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import net.javaguides.springboot.entities.ForensicCase;

@Controller
@RequestMapping("/forensicCase")
public class ForensicCaseController {
	@Autowired
	private ForensicCaseService forensicCaseService;
	
	
	@GetMapping("/home2")
	public String dashboard(Model model,Principal principal) {
		
		return "home2";		
	}
	
//	add form controller
	@GetMapping("/open-case")
	public String openCaseForm(Model model) {
		model.addAttribute("listCases",forensicCaseService.getAllCases());
		return "open_case_form";
	}
	@GetMapping("/new-case")
	public String addCase(Model model) {
		ForensicCase forensicCase = new ForensicCase();
		model.addAttribute("forensicCase", forensicCase);
		return "new_case";
	}
	
	@PostMapping("/saveforensicCase")
	public String saveforensicCase(@ModelAttribute("forensicCase") ForensicCase forensicCase) {
		// save employee to database
		forensicCaseService.saveforensicCase(forensicCase);
		return "redirect:/home2";
	}
	
	
	

	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		ForensicCase forensicCase = forensicCaseService.getForensicCaseByIdd(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("forensicCase", forensicCase);
		return  "update_case";
	}
	
	
	@GetMapping("/deleteForensicCase/{id}")
	public String deleteForensicCase(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.forensicCaseService.deleteForensicCaseById(id);
		return "redirect:/home2";
	}
	
	
	
	
	// display list of employees
//	@GetMapping("/")
//	public String viewHomePage(Model model) {
//		return findPaginated(1, "Name", "asc", model);		
//	}
//	
//	@GetMapping("/showNewCasesForm")
//	public String showNewCasesForm(Model model) {
//		// create model attribute to bind form data
//		ForensicCase forensicCase = new ForensicCase();
//		model.addAttribute("forensicCase", forensicCase);
//		return "new_case";
//	}
	
//	@PostMapping("/saveforensicCase")
//	public String saveforensicCase(@ModelAttribute("forensicCase") ForensicCase forensicCase) {
//		// save employee to database
//		forensicCaseService.saveforensicCase(forensicCase);
//		return "redirect:/";
//	}
//	
//	@GetMapping("/showFormForUpdate/{id}")
//	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
//		
//		// get employee from the service
//		ForensicCase forensicCase = forensicCaseService.getForensicCaseByIdd(id);
//		
//		// set employee as a model attribute to pre-populate the form
//		model.addAttribute("forensicCase", forensicCase);
//		return "update_forensicCase";
//	}
//	
//	@GetMapping("/deleteForensicCase/{id}")
//	public String deleteForensicCase(@PathVariable (value = "id") long id) {
//		
//		// call delete employee method 
//		this.forensicCaseService.deleteForensicCaseById(id);
//		return "redirect:/";
//	}
//	
//	
//	@GetMapping("/page/{pageNo}")
//	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
//			@RequestParam("sortField") String sortField,
//			@RequestParam("sortDir") String sortDir,
//			Model model) {
//		int pageSize = 5;
//		
//		Page<ForensicCase> page = forensicCaseService.findPaginated(pageNo, pageSize, sortField, sortDir);
//		List<ForensicCase> listCases = page.getContent();
//		
//		model.addAttribute("currentPage", pageNo);
//		model.addAttribute("totalPages", page.getTotalPages());
//		model.addAttribute("totalItems", page.getTotalElements());
//		
//		model.addAttribute("sortField", sortField);
//		model.addAttribute("sortDir", sortDir);
//		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
//		
//		model.addAttribute("listCases", listCases);
//		return "index";
//	}	
	
	
}
