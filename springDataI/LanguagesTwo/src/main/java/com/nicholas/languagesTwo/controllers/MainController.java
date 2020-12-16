package com.nicholas.languagesTwo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nicholas.languagesTwo.services.LanguageTwoService;

@Controller
public class MainController {

	private final LanguageTwoService langService;
	
	public MainController(LanguageTwoService langService) {
		this.langService = langService;
	}
	
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("Language") LanguageTwo language)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
