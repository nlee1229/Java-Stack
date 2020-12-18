package com.nicholas.beltReviewer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicholas.beltReviewer.models.Message;
import com.nicholas.beltReviewer.repositories.MessageRepository;

@Service
public class MessageService {

	@Autowired 
	private MessageRepository mRepo;
	
	//find all messages so we can render all messages on .jsp
	public List<Message> allMessages() {
		return mRepo.findAll();
	}
	
	//find messages by id
	public Message findMessageById(Long id) {
		Optional<Message> message = mRepo.findById(id);
		if(message.isPresent()) {
			return message.get();
		} else {
			return null;
		}
	}
	
	//create & save message
	public void saveMessage(Message message) {
		
		mRepo.save(message);
	}
	
	//edit & update message
	public void updateMessage(Long id, Message message) {
		Message old = this.findMessageById(id);
		old.setComment(message.getComment());
		mRepo.save(old);
	}
	
	//delete message
	public void deleteMessage(Long id) {
		mRepo.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

	