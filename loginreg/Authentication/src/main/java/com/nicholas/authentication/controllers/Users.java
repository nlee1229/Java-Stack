package com.nicholas.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nicholas.authentication.models.User;
import com.nicholas.authentication.services.UserService;
import com.nicholas.authentication.validators.UserValidator;

@Controller
public class Users {
	 private final UserService userService;
	 
	 private final UserValidator userValidator;
	 
	 public Users(UserService userService, UserValidator userValidator) {
	     this.userService = userService;
	     this.userValidator = userValidator;
	 }
	 
	 @RequestMapping("/registration")
	 public String registerForm(@ModelAttribute("user") User user) {
	     return "registrationPage.jsp";
	 }
	 
//	 @RequestMapping("/login")
//	 public String login() {
//	     return "loginPage.jsp";
//	 }
	 
	 //-----submitting user and adding it to database-------//
	 @RequestMapping(value="/registration", method=RequestMethod.POST)
	 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		 // if result has errors, return the registration page (don't worry about validations just now)
	     // else, save the user in the database, save the user id in session, and redirect them to the /home route
		 	userValidator.validate(user, result);
		 	if(result.hasErrors()) {
	            return "loginPage.jsp";
	        }
	        User u = userService.registerUser(user);
	        session.setAttribute("userId", u.getId());
	        return "redirect:/home";
	 }
	 
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes model, HttpSession session) {
	  
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if(isAuthenticated) {
			 User u = userService.findByEmail(email);
			 session.setAttribute("userId", u.getId());
			 return "redirect:/home";

		 } else {
			 model.addFlashAttribute("error", "Login failed! Please try again.");
		 }
		 	return "redirect:/registration";
	 }
	 
	 @RequestMapping("/home")
	 public String home(HttpSession session, Model model) {
	     // get user from session, save them in the model and return the home page
		 Long userId = (Long) session.getAttribute("userId");
		 User u = userService.findUserById(userId);
		 model.addAttribute("user", u);
		 return "homePage.jsp";
		 }
		 
	 
	 @RequestMapping("/logout")
	 public String logout(HttpSession session) {
	     // invalidate session
	     // redirect to login page
		 session.invalidate();
		 return "redirect:/registration";
	 }
}