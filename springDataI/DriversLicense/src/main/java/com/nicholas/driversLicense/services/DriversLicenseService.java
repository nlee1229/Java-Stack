package com.nicholas.driversLicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicholas.driversLicense.models.License;
import com.nicholas.driversLicense.models.Person;
import com.nicholas.driversLicense.repositories.LicenseRepo;
import com.nicholas.driversLicense.repositories.PersonRepo;


@Service
public class DriversLicenseService {

	@Autowired
	private LicenseRepo lRepo;
	
	@Autowired
	private PersonRepo pRepo;
	
	public List<Person> findAllPersons() {
		return pRepo.findAll();
		
	}
//------------ retrieving a License from the database -----------------------

	public License findLicenseById(Long id) {
		// use optional in case the value is null
		Optional<License> license = lRepo.findById(id);
		if(license.isPresent()) {
			return license.get();
		}
		else {
			return null;
		}
	}
	
//------------------retrieving a Person from the database -------------------
	
	public Person findPersonById(Long id) {
		// use optional in case the value is null
		Optional<Person> person = pRepo.findById(id);
		if(person.isPresent()) {
			return person.get();
		}
		else {
			return null;
		}
	}
	
//-------------------- saves new License to the database----------------------
	public License createLicense(License license) {
		return lRepo.save(license);
	}
	
//-------------------- saves new Person to the database-----------------------
	public Person createPerson(Person person) {
		return pRepo.save(person);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
