package com.nicholas.theCoding;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

	//strictly for loading the home page
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/checkPass", method=RequestMethod.POST)
	
	public String code(@RequestParam String password, HttpSession session) {
		//set the password in sessions
		session.setAttribute("pw", "bushido");
		//checking to see if they entered nothing, redirect to homepage
		if (password.equals("")) {
			return "redirect:/";
		//checking to see if password does not match our saved pw
		} else if(!password.equals(session.getAttribute("pw"))) {
			return "redirect:/createError";
		} else {
			return "redirect:/code";
		}
	}
	
	@RequestMapping("/code")
	public String success() {
		return "code.jsp";
	}
	
	@RequestMapping("/createError")
	public String flashMessages(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
	}
	
	
	}
