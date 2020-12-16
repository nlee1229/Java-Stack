package com.nicholas.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nicholas.languages.models.Language;
import com.nicholas.languages.services.LanguageService;

@Controller
public class MainController {

private final LanguageService langService;
	
	public MainController(LanguageService service) {
		this.langService = service;
	}
	
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("Language")Language language) {
		List<Language> languages = langService.allLanguages();
		model.addAttribute("languages", languages);
		return "/dashboard.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	   public String create(@Valid @ModelAttribute("Language") Language lang, BindingResult result, Model model){ 
	       if (result.hasErrors()) { 
	    	   List<Language> languages = langService.allLanguages();
	   			model.addAttribute("languages", languages);
	           return "/dashboard.jsp";
	       } else {
	           langService.createLanguage(lang);
	           return "redirect:/languages";
	       }
	   }
	
	@RequestMapping("/languages/{id}")
	public String show(Model model, @PathVariable ("id") Long id) {
		Language langy = langService.findLanguage(id);
		model.addAttribute("langie", langy);
//		System.out.println("Are we getting in here?");
		return "/show.jsp";
	}
	
	// get to the page to edit
	@RequestMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		 Language language = langService.findLanguage(id);
         model.addAttribute("language", language);
         return "/edit.jsp";
	}
	
	// actually edit and update to database
    @RequestMapping(value="/languages/{id}", method=RequestMethod.POST)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result)
    {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
            langService.updateLanguage(language);
            return "redirect:/languages";
        }
    
    }
    
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        langService.deleteLanguage(id);
        return "redirect:/languages";
    }
    
}
