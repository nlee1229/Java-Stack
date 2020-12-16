package com.nicholas.studentRoster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nicholas.studentRoster.models.Contact;

public interface ContactRepo extends CrudRepository<Contact, Long> {
	List<Contact> findAll();

}
