package com.nicholas.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicholas.dojosAndNinjas.models.Ninja;
import com.nicholas.dojosAndNinjas.repos.NinjaRepo;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepo ninjaRepo;
	
	//--------------retrieving(finding) all ninjas from the database (get all ninjas)------------//
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
	//---------------retrieving a ninja from the database by id (find by id)------------//
	public Ninja findbyId(Long id) {
		//Use optional in case the value is null
		Optional<Ninja> ninja = ninjaRepo.findById(id);
		if(ninja.isPresent()) {
			return ninja.get();
		}
		else {
			return null;
		}
	}
	
	//------saves the ninja to database whether that ninja exists in the database or not (create and update)-------//
	public Ninja save(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	//-----------------deletes ninja by id------------------//
	public void Delete(Long id) {
		ninjaRepo.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
}
