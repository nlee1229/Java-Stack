package com.nicholas.dojosAndNinjas3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicholas.dojosAndNinjas3.models.Dojo;
import com.nicholas.dojosAndNinjas3.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepository;
	
	//-----find all dojos-----//
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}
	
	//-------find dojo by id-------//
	public Dojo findDojoById(Long id) {
		Optional<Dojo> dojo = dojoRepository.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		} else {
			return null;
		}
	}
	
	//------create & save dojo------//
	public void saveDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}
	
	//-------edit and update dojo--------//
	public void updateDojo(Long id, Dojo dojo) {
		Dojo old = this.findDojoById(id);
		old.setLocation(dojo.getLocation());
		old.setReview(dojo.getReview());
		old.setDate(dojo.getDate());
		old.setRating(dojo.getRating());
		dojoRepository.save(old);
	}
	
	//-------delete dojo--------//
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}

}
