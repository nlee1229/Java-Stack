package com.Nicholas.Counter;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/your_server")
public class CounterController {

	
	@RequestMapping("/")
	//Model model is like a dictionary aka 'context'
	public String welcomePage(HttpSession session, Model model) {
		//'count' being passed in is a key
		Object sessionCount = session.getAttribute("count");
		
		//if there is no 'count' yet, the count would be set to 0
		if(sessionCount == null) {
			session.setAttribute("count", 0);
			model.addAttribute("count", session.getAttribute("count"));
			}
		
		//if there is a 'count', then will add one
		session.setAttribute("count", (Integer) session.getAttribute("count") + 1);
		model.addAttribute("count", session.getAttribute("count"));
		
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String countPage() {
		return "counter.jsp";
	}	
}
