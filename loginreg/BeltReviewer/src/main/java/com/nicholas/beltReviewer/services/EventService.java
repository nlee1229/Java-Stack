package com.nicholas.beltReviewer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicholas.beltReviewer.models.Event;
import com.nicholas.beltReviewer.repositories.EventRepository;

@Service
public class EventService {

	@Autowired 
	private EventRepository eRepo;
	
	//find all events so we can render all events on .jsp
	public List<Event> allEvents() {
		return eRepo.findAll();
	}
	
	//find events by id
	public Event findEventById(Long id) {
		Optional<Event> event = eRepo.findById(id);
		if(event.isPresent()) {
			return event.get();
		} else {
			return null;
		}
	}
	
	//create & save event
	public void saveEvent(Event event) {
		eRepo.save(event);
	}
	
	//edit & update event
	public void updateEvent(Long id, Event event) {
		Event old = this.findEventById(id);
		old.setName(event.getName());
		old.setDate(event.getDate());
		old.setLocation(event.getLocation());
		old.setState(event.getState());
		eRepo.save(old);
	}
	
	//delete event
	public void deleteEvent(Long id) {
		eRepo.deleteById(id);
	}
	
	
	
}

