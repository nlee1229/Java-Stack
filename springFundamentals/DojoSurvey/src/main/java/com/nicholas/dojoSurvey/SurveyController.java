package com.nicholas.dojoSurvey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {
	
	@RequestMapping("/")
			public String index() {
				return "index.jsp";
			}

	//path to process the information
	@RequestMapping(path="/submit", method=RequestMethod.POST)
	public String submitInfo(@RequestParam String name, @RequestParam String dojo, @RequestParam String lang, @RequestParam(required=false) String comm, HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("loc", dojo);
		session.setAttribute("fav_lang", lang);
		//checking to see if user puts in a comment
		if (comm.equals("")) {
			session.setAttribute("comment", "");
		} else {
			session.setAttribute("comment", comm);
		}
		return "redirect:/result";
		
	}
	
	@RequestMapping("/result")
	public String resultPage() {
		return "result.jsp";
	}

	
	
	
	
	
	
	
	
	
	
	
}
