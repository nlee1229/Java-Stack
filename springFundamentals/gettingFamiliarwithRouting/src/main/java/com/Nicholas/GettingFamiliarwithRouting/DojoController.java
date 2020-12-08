package com.Nicholas.GettingFamiliarwithRouting;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/m/{track}/{module}/{lesson}")
	public String showController(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
		return "Track: " + track + ", Module: " + module + " , Lesson: " + lesson;
	}
	@RequestMapping("{dojo}")
	public String dojo (@PathVariable("dojo") String dojo) {
		if (dojo.equals("dojo")) {
			return ("The dojo is awesome!");
		}
		if (dojo.equals("burbank-dojo")) {
			return ("Burbank Dojo is located in Southern California.");
		}
		if (dojo.equals("san-jose")) {
			return ("SJ dojo is the headquarters.");
		}
		return "Type in a CD location.";
	}
}
	
