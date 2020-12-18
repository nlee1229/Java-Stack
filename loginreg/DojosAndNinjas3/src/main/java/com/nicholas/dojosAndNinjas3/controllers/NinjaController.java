package com.nicholas.dojosAndNinjas3.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nicholas.dojosAndNinjas3.models.Dojo;
import com.nicholas.dojosAndNinjas3.models.Ninja;
import com.nicholas.dojosAndNinjas3.services.DojoService;
import com.nicholas.dojosAndNinjas3.services.NinjaService;
import com.nicholas.dojosAndNinjas3.validators.NinjaValidator;


@Controller
public class NinjaController {
	
	@Autowired
	private NinjaService ninjaService;
	 
	@Autowired
	 private NinjaValidator ninjaValidator;
	 
	 @Autowired
	 private DojoService dService;
	
	 
	 @RequestMapping("/registration")
	 public String registerForm(@ModelAttribute("ninja") Ninja ninja) {
	     return "registrationPage.jsp";
	 }
	 
//	 @RequestMapping("/login")
//	 public String login() {
//	     return "loginPage.jsp";
//	 }
	 
	 //-----submitting ninja and adding it to database-------//
	 @RequestMapping(value="/registration", method=RequestMethod.POST)
	 public String registerNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, HttpSession session) {
		 // if result has errors, return the registration page (don't worry about validations just now)
	     // else, save the ninja in the database, save the ninja id in session, and redirect them to the /home route
		 	ninjaValidator.validate(ninja, result);
		 	if(result.hasErrors()) {
	            return "registrationPage.jsp";
	        }
	        Ninja u = ninjaService.registerNinja(ninja);
	        session.setAttribute("ninjaId", u.getId());
	        return "redirect:/home";
	 }
	 
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	 public String loginNinja(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes model, HttpSession session) {
	  
		boolean isAuthenticated = ninjaService.authenticateNinja(email, password);
		if(isAuthenticated) {
			 Ninja u = ninjaService.findByEmail(email);
			 session.setAttribute("ninjaId", u.getId());
			 return "redirect:/home";

		 } else {
			 model.addFlashAttribute("error", "Login failed! Please try again.");
		 }
		 	return "redirect:/registration";
	 }
	 
	 @RequestMapping("/home")
	 public String home(@ModelAttribute ("Dojo") Dojo dojo, HttpSession session, Model model) {
	     // get ninja from session, save them in the model and return the home page
		 Long ninjaId = (Long) session.getAttribute("ninjaId");
		 Ninja u = ninjaService.findNinjaById(ninjaId);
		 model.addAttribute("ninja", u);
		 model.addAttribute("dojos",dService.allDojos());
		 return "homePage.jsp";
		 }
	 
//	 @RequestMapping("/home")
//	 public String home(HttpSession session, Model model) {
//	     // get user from session, save them in the model and return the home page
//		 Long userId = (Long) session.getAttribute("userId");
//		 User u = userService.findUserById(userId);
//		 model.addAttribute("user", u);
//		 return "homePage.jsp";
//		 }
		 
	 
	 @RequestMapping("/logout")
	 public String logout(HttpSession session) {
	     // invalidate session
	     // redirect to login page
		 session.invalidate();
		 return "redirect:/registration";
	 }
	
}
