package com.nicholas.driversLicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicholas.driversLicense.models.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long> {
	
	// Retrieves all person from the database
	List<Person> findAll();
}
