package com.nicholas.beltReviewer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nicholas.beltReviewer.models.Event;
import com.nicholas.beltReviewer.models.Message;
import com.nicholas.beltReviewer.models.User;
import com.nicholas.beltReviewer.services.EventService;
import com.nicholas.beltReviewer.services.MessageService;
import com.nicholas.beltReviewer.services.UserService;

@Controller
public class MainController {

	@Autowired 
	private MessageService mService;
	
	@Autowired
	private EventService eService;
	
	@Autowired
	private UserService uService;
	
	// actually processing the form to jsp to add new event
	@PostMapping("/home/createEvent")
	public String create(@Valid @ModelAttribute("Event") Event event, BindingResult result, HttpSession session) {
		User user = uService.findUserById((Long)session.getAttribute("userId"));
		if(result.hasErrors()) {
			return "homePage.jsp";
		} else {
			event.setUser(user);
			eService.saveEvent(event);
			return "redirect:/home";
		}
	}
	
	//------------DELETE AN EVENT-------------//
	@GetMapping("/home/deleteEvent/{id}") 
	public String deleteEvent(@PathVariable("id") Long id) {
		eService.deleteEvent(id);
		return "redirect:/home";
	}
	
	//--------------RENDER THE EVENT PAGE---------------//
	@GetMapping("/home/editEvent/{id}")
	public String editEvent(@PathVariable("id") Long id, Model model, @ModelAttribute ("Event") Event event) {
		model.addAttribute("event", eService.findEventById(id));
		return "editEvent.jsp";
	}
	
	//--------------PROCESS THE EVENT PAGE---------------//
	@PostMapping("/home/editEvent/{id}")
	public String processEditEvent(@Valid @PathVariable("id") Long id, @Valid @ModelAttribute("Event") Event event, BindingResult result) {
		if(result.hasErrors()) {
			return "editEvent.jsp";
		} else {
			Long eventId = event.getId();
			eService.updateEvent(eventId, event);
		return "redirect:/home";
		}
	}
	
	//-----------------RENDER THE SHOW PAGE-----------------//
	@GetMapping("/home/showEvent/{id}")
	public String showEvent(@PathVariable("id") Long id, Model model, @ModelAttribute ("Message") Message message) {
		//getting the specific event by id url
		Event eve = eService.findEventById(id);
		List<Message> msg = eve.getMessages();
		model.addAttribute("message", msg);
		model.addAttribute("event", eve);
		model.addAttribute("unicorns", "hello world");
		return "showEvent.jsp";
	}
	
	//----------------ACTUALLY PROCESSING THE MESSAGE-----------------//
	@PostMapping("/createComment/{id}")
	public String processShowEvent(@PathVariable("id") Long id, @Valid @ModelAttribute ("Message") Message message, BindingResult result, HttpSession session, Model model) {
		//connect user to msg
		User user = uService.findUserById((Long)session.getAttribute("userId"));
		if(result.hasErrors()) {
			Event eve = eService.findEventById(id);
			List<Message> msg = eve.getMessages();
			model.addAttribute("message", msg);
			model.addAttribute("event", eve);
			model.addAttribute("unicorns", "hello world");
			return "showEvent.jsp";
		} else {
			message.setUser(user);
			mService.saveMessage(message);
			return "redirect:/home/showEvent/"+id;
		}
	}
		


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
