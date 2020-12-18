package com.nicholas.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicholas.dojosAndNinjas.models.Dojo;
import com.nicholas.dojosAndNinjas.models.Ninja;
import com.nicholas.dojosAndNinjas.repositories.NinjaRepo;

@Service
public class NinjaService {

	@Autowired 
	private NinjaRepo nRepo;
	
	//----------retrieving (finding) all ninjas from the database-----------//
	
	public List<Ninja> allNinjas() {
		return nRepo.findAll();
	}
	
	//---------find ninja by id----------//
	public Ninja findNinjaById(Long id) {
	//------optional allows it to run regardless of existence------//
		Optional<Ninja> ninja = nRepo.findById(id);
		if (ninja.isPresent()) {
			//getting specific ninja by the id
			return ninja.get();
			//if id does not exist, simply returning null instead of crashing server
		} else {
			return null;
		}
	}
	
	//-------create a ninja & save--------// //Ninja ninja comes from the form
	public Ninja saveNinja(Ninja ninja) {
		return nRepo.save(ninja);
	}
	
	//-------edit/update a ninja--------//
	public Ninja updateNinja(Long id, Ninja ninja) {
		Ninja ninja1 = this.findNinjaById(id);
		
		ninja1.setFirstName(ninja.getFirstName());
		ninja1.setLastName(ninja.getLastName());
		ninja1.setAge(ninja.getAge());
	
		ninja1.setDojo(ninja.getDojo());
		
		nRepo.save(ninja1);
		return ninja1;
	}

	
	//------delete a ninja------//
	public void deleteNinja(Long id) {
		nRepo.deleteById(id);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
