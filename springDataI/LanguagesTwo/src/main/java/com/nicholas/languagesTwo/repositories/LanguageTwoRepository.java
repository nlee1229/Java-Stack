package com.nicholas.languagesTwo.repositories;

import java.awt.print.Book;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicholas.languagesTwo.models.LanguageTwo;

@Repository
public interface LanguageTwoRepository extends CrudRepository<LanguageTwo, Long> {

	// Retrieves all languages from the database
	List<LanguageTwo> findAll();
	
	List<Book> findbyName(String search);
	
	List<LanguageTwo> findByCreator(String search);
	
}
