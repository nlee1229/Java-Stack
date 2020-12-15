package com.nicholas.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicholas.dojosAndNinjas.models.Dojo;
import com.nicholas.dojosAndNinjas.repos.DojoRepo;

@Service
public class DojoService {

	@Autowired
	private DojoRepo dojoRepo;
	
	//--------------retrieving(finding) all dojos from the database (get all dojos)------------//
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	//---------------retrieving a dojo from the database by id (find by id)------------//
	public Dojo findById(Long id) {
		//Use optional in case the value is null
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}
		else {
			return null;
		}
	}
	
	//------saves the dojo to database whether that dojo exists in the database or not (create and update)-------//
	public Dojo save(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	//-----------------deletes dojo by id------------------//
	public void Delete(Long id) {
		dojoRepo.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
}
