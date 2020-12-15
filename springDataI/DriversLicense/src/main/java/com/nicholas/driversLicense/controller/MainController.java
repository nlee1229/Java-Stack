package com.nicholas.driversLicense.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nicholas.driversLicense.models.License;
import com.nicholas.driversLicense.models.Person;
import com.nicholas.driversLicense.services.DriversLicenseService;

@Controller
public class MainController {
	
	@Autowired
	private DriversLicenseService dlServ;
	
	
	// ------------------- CREATE A NEW PERSON ----------------------- // 
	@GetMapping("/persons/new")
	public String persons(@ModelAttribute("personObj") Person person) {
		return "newPerson.jsp";
	}
	
	// -------------- PROCESSING THE CREATION OF A NEW PERSON ----------- //
	@PostMapping("/persons/new")
	public String createPerson(@Valid @ModelAttribute("personObj") Person person, BindingResult results) {
		if(results.hasErrors()) {
			return "newPerson.jsp";
		}
		else {
			dlServ.createPerson(person);
			return "redirect:/licenses/new";
		}
	}
	
	// ----------------- RENDERS THE NEW LICENSE FORM PAGE ----------------- //
	@GetMapping("/licenses/new")
	public String newLicense(@ModelAttribute("licenseObj") License license, Model model) {
		
		List<Person> persons = dlServ.findAllPersons();
		model.addAttribute("persons", persons);
		return "newLicense.jsp";
	}
	
	
	// -------------------- CREATES A NEW LICENSE IN THE DATABASE ---------------------- //
	@PostMapping("/licenses/new")
	public String createLicense(@Valid @ModelAttribute("licenseObj") License license, BindingResult results) {
		if(results.hasErrors()) {
			return "newLicense.jsp";
		}
		else {
			license.setNumber(String.format("%06d", license.getPerson().getId()));
			dlServ.createLicense(license);
			return "redirect:/persons/" + license.getId();
		}
	}

	// ------------------------ RENDERING ONE PERSONS INFO -------------------------- //
		@GetMapping("/persons/{id}")
		public String show(@PathVariable("id")Long id, Model model) {
			
			Person onePerson = dlServ.findPersonById(id);
			// PASS PERSON TO JSP
			model.addAttribute("person", onePerson);
			return "show.jsp";
		}
		
}