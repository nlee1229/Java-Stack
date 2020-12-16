package com.nicholas.languagesTwo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nicholas.languagesTwo.models.LanguageTwo;
import com.nicholas.languagesTwo.repositories.LanguageTwoRepository;

@Service
public class LanguageTwoService {

	private final LanguageTwoRepository langRepo;
	
	// initializing what the langRepo is the moment that language service is created or used
	public LanguageTwoService(LanguageTwoRepository langRepo) {
		this.langRepo=langRepo;
	}
	
	public List<LanguageTwo> allLanguages() {
		return langRepo.findAll();
	}
	
	//creates a language
}
