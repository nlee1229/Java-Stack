package com.nicholas.languages.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicholas.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
	
	//Retrieves all languages from the database
	List<Language> findAll();
	
	List<Language> findByCreator(String search);

}
