package com.nicholas.dojosAndNinjas3.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nicholas.dojosAndNinjas3.models.Dojo;
import com.nicholas.dojosAndNinjas3.models.Ninja;
import com.nicholas.dojosAndNinjas3.services.DojoService;
import com.nicholas.dojosAndNinjas3.services.NinjaService;

@Controller
public class MainController {
	
	@Autowired
	private NinjaService nService;
	
	@Autowired
	private DojoService dService;
	
	
	//----actually processing the form to jsp to add new dojos-----//
	@PostMapping("/home/createDojo")
	public String create(@Valid @ModelAttribute("Dojo") Dojo dojo, BindingResult result, HttpSession session) {
		Ninja ninja = nService.findNinjaById((Long)session.getAttribute("ninjaId"));
		if(result.hasErrors()) {
			return "homePage.jsp";
		} else {
			dojo.setNinja(ninja);
			dService.saveDojo(dojo);
			return "redirect:/home";
		}
	}
	
	//--------Delete a dojo------//
	@GetMapping("/home/deleteDojo/{id}")
	public String deleteDojo(@PathVariable("id") Long id) {
		dService.deleteDojo(id);
		return "redirect:/home";
	}
	
	//-----Render edit dojo page------//
	@GetMapping("/home/editDojo/{id}")
	public String editDojo(@PathVariable("id") Long id, Model model, @ModelAttribute("Dojo") Dojo dojo) {
		model.addAttribute("dojo", dService.findDojoById(id));
		return "editDojo.jsp";
	}
	
	
	
	//-------Edit and render dojo page-------//
	@PostMapping("/home/editDojo/{id}")
	public String processEditDojo(@Valid @PathVariable("id") Long id, @Valid @ModelAttribute("Dojo") Dojo dojo, BindingResult result) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
