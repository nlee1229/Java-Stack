package com.nicholas.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicholas.dojosAndNinjas.models.Dojo;
import com.nicholas.dojosAndNinjas.repositories.DojoRepo;

@Service
public class DojoService {

	@Autowired 
	private DojoRepo dRepo;
	
	//----------retrieving (finding) all dojos from the database-----------//
	
	public List<Dojo> allDojos() {
		return dRepo.findAll();
	}
	
	//---------find dojo by id----------//
	public Dojo findDojoById(Long id) {
	//------optional allows it to run regardless of existence------//
		Optional<Dojo> dojo = dRepo.findById(id);
		if (dojo.isPresent()) {
			//getting specific dojo by the id
			return dojo.get();
			//if id does not exist, simply returning null instead of crashing server
		} else {
			return null;
		}
	}
	
	//-------create a dojo & save--------// //Dojo dojo comes from the form
	public Dojo saveDojo(Dojo dojo) {
		return dRepo.save(dojo);
	}
	
	//-------edit/update a dojo--------//
	public Dojo updateDojo(Long id, String name) {
		Dojo dojo = this.findDojoById(id);
		
		dojo.setName(name);
		
		dRepo.save(dojo);
		return dojo;
	}

	
	//------delete a dojo------//
	public void deleteDojo(Long id) {
		dRepo.deleteById(id);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
