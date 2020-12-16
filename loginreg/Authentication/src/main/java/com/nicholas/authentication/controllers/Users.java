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

import com.nicholas.authentication.models.User;
import com.nicholas.authentication.services.UserService;

@Controller
public class Users {
	 private final UserService userService;
 
	 public Users(UserService userService) {
	     this.userService = userService;
	 }
	 
	 @RequestMapping("/registration")
	 public String registerForm(@ModelAttribute("user") User user) {
	     return "registrationPage.jsp";
	 }
	 @RequestMapping("/login")
	 public String login() {
	     return "loginPage.jsp";
	 }
	 
	 //-----submitting user and adding it to database-------//
	 @RequestMapping(value="/registration", method=RequestMethod.POST)
	 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		 // if result has errors, return the registration page (don't worry about validations just now)
	     // else, save the user in the database, save the user id in session, and redirect them to the /home route
		 if(result.hasErrors()) {
			 return "registrationPage.jsp";
		 }
		 User u = userService.registerUser(user);
		 return "redirect:/home";
	 }		
	 
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttribute flashMessage) {
	     // if the user is authenticated, save their user id in session
	     // else, add error messages and return the login page
		 if(userService.authenticateUser(email, password)) {
			 User thisUser = userService.findByEmail(email);
			 session.setAttribute("userId", thisUser.getId());
			 return "redirect:/login";
//			 Long thisId = (Long) session.getAttribute("userId");
		 }
		 flashMessage.addFlashAttribute("error", "failed to login");
		 return "redirect:/login";
				
	 }
	 
	 @RequestMapping("/home")
	 public String home(HttpSession session, Model model) {
	     // get user from session, save them in the model and return the home page
		 Long id = (Long) session.getAttribute("userId");
				 
		 if(id != null) {
			 User loggedInUser = userService.findUserById(id);
			 model.addAttribute("user", loggedInUser);
			 return "homePage.jsp";
		 }
			 return "redirect:/login";
		 }
		 
	 
	 @RequestMapping("/logout")
	 public String logout(HttpSession session) {
	     // invalidate session
	     // redirect to login page
		 session.invalidate();
		 return "redirect:/login";
	 }
}