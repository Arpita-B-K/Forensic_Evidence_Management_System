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

import net.javaguides.springboot.service.EvidenceService;
import net.javaguides.springboot.service.ForensicCaseService;
import net.javaguides.springboot.service.LabService;
import net.javaguides.springboot.service.OfficerService;
import net.javaguides.springboot.entities.Evidence;
import net.javaguides.springboot.entities.ForensicCase;
import net.javaguides.springboot.entities.Lab;
import net.javaguides.springboot.entities.Officer;



@Controller
@RequestMapping("/evidence")
public class EvidenceController {
	
	@Autowired
	private EvidenceService evidenceService;
	@Autowired
	private ForensicCaseService forensicCaseService;
	@Autowired
	private LabService labService;
	@Autowired
	private OfficerService officerService;
	
	
	@GetMapping("/home2")
	public String dashboard(Model model,Principal principal) {
		
		return "home2";		
	}
	
//	add form controller
	@GetMapping("/open-evidence")
	public String openEvidenceForm(Model model) {
		model.addAttribute("listEvidence",evidenceService.getAllEvidence());
		return "open_evidence_form";
	}
	@GetMapping("/new-evidence")
	public String addCase(Model model) {
		Evidence evidence = new Evidence();
		model.addAttribute("evidence", evidence);
		List<ForensicCase> cases = forensicCaseService.getAllCases();
		model.addAttribute("cases", cases);
		List<Lab> lab = labService.getAllLab();
		model.addAttribute("lab", lab);
		List<Officer> officer = officerService.getAllOfficer();
		model.addAttribute("officer", officer);
		
		return "new_evidence";
	}
	
	@PostMapping("/saveEvidence")
	public String saveEvidence(@ModelAttribute("evidence") Evidence evidence) {
		// save employee to database
		evidenceService.saveEvidence(evidence);
		return "redirect:/home2";
	}
	
	
	

	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		Evidence evidence = evidenceService.getEvidenceByIdd(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("evidence", evidence);
		return  "update_evidence";
	}
	
	
	@GetMapping("/deleteEvidence/{id}")
	public String deleteEvidence(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.evidenceService.deleteEvidenceById(id);
		return "redirect:/home2";
	}

}
