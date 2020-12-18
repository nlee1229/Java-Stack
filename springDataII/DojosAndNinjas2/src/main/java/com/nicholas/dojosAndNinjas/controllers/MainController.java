package com.nicholas.dojosAndNinjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nicholas.dojosAndNinjas.models.Dojo;
import com.nicholas.dojosAndNinjas.models.Ninja;
import com.nicholas.dojosAndNinjas.services.DojoService;
import com.nicholas.dojosAndNinjas.services.NinjaService;

@Controller
public class MainController {

	@Autowired 
	private DojoService dService;
	
	@Autowired
	private NinjaService nService;
	
	// renders the home page showing all dojos
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("dojo", dService.allDojos());
		return "home.jsp";
	}
	
	// renders the creation page for dojos
	@GetMapping("/addDojo")
	public String addDojo(@ModelAttribute("Dojo") Dojo dojo) {
		return "createDojo.jsp";
	}
	
	// actually processing the form to jsp to add new dojos
	@PostMapping("/addDojo")
	public String processDojo(@Valid @ModelAttribute("Dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "createDojo.jsp";
		} else {
			dService.saveDojo(dojo);
			return "redirect:/";
		}
	}
	
	// delete a dojo
	@GetMapping("/deleteDojo/{id}")
	public String deleteDojo(@PathVariable("id") Long id) {
		dService.deleteDojo(id);
		return "redirect:/";
	}
	
	// renders the edit page with the info of the dojo you're trying to edit
	@GetMapping("/editDojo/{id}") 
	public String editDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dService.findDojoById(id));
		return "editDojo.jsp";
	}
	
	
	// actually edit a dojo
	@PostMapping("/editDojo/{id}")
	public String processEditDojo(@Valid @ModelAttribute("Dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "editDojo.jsp";
		} else {
			Long id = dojo.getId();
			dService.updateDojo(id, dojo);
			return "redirect:/";
		}
		
	}
	
	// renders the creation page for ninjas
	@GetMapping("/addNinja")
	public String addNinja(@ModelAttribute("Ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dService.allDojos());
		return "createNinja.jsp";
	}
	
	// actually processing the form to jsp to add new ninjas
	@PostMapping("/addNinja")
	public String processDojo(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "createNinja.jsp";
		} else {
			nService.saveNinja(ninja);
			return "redirect:/";
		}
	}
	
	// renders the edit page with the info of the ninja you're trying to edit
	@GetMapping("/editNinja/{id}") 
	public String editNinja(@ModelAttribute ("Ninja") Ninja ninja, @PathVariable("id") Long id, Model model) {
		model.addAttribute("ninja", nService.findNinjaById(id));
		model.addAttribute("dojos", dService.allDojos());
		return "editNinja.jsp";
	}
	
	// actually edit a ninja
		@PostMapping("/editNinja/{id}")
		public String processEditNinja(@Valid @ModelAttribute("Ninja") Ninja ninja, BindingResult result) {
			if (result.hasErrors()) {
				return "editNinja.jsp";
			} else {
				Long id = ninja.getId();
				nService.updateNinja(id, ninja);
				return "redirect:/";
			}
			
		}
		
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
