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
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;

//----------------------Show all dojos if there are any--------------------//
	@GetMapping("/")
	public String allDojos(Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "index.jsp";
	}

	@GetMapping("/createDojo")
	public String showDojoCreate(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@PostMapping("/createDojo")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		dojoService.save(dojo);
		return"redirect:/";
	}
	
	//?????????????????????????????????????????(50:20)
	//Pass in @ModelAttribute for all create pages... Model model is bc we're going to have to pass some data over to the view
	@GetMapping("/createNinja")
	public String showNinjaCreate(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "newNinja.jsp";
	}
	
	@PostMapping("/createNinja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
		return "newNinja.jsp";
		}
		ninjaService.save(ninja);
		return "redirect:/";
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojoObj = dojoService.findById(id);
		model.addAttribute("dojo", dojoObj);
		return "show.jsp";
	}
	
	
	
	
	
	
	
}
