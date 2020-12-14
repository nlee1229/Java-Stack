package com.nicholas.driversLicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicholas.driversLicense.models.License;

@Repository
public interface LicenseRepo extends CrudRepository<License, Long> {
	
	// Retrieves all licenses from the database
	List<License> findAll();
}
