package com.nicholas.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nicholas.languages.models.Language;
import com.nicholas.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private final LanguageRepository langRepo;
	
	// initialzing what that lang repo is the moment that language service is created or used
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	
	public List<Language> allLanguages() {
		return langRepo.findAll();
	}
	
	// creates a language
	public Language createLanguage(Language l) {
		return langRepo.save(l);
	}

	// updates a language from LanguagesApi.java
	public Language updateLanguage(Long id, String name, String creator, String currentVersion) {
		Language lang = this.findLanguage(id);
		
		lang.setName(name);
		lang.setCreator(creator);
		lang.setCurrentVersion(currentVersion);
		
		langRepo.save(lang);
		return lang;

	}
	
	// updates a language from LanguagesController.java
	public Language updateLanguage(Language lang) {
	
		langRepo.save(lang);
		return lang;
	}
	
	//deletes a language
	
	public void deleteLanguage(Long id) {
		langRepo.deleteById(id);
	}

	
	// retrieves a language object or retrieves null
	public Language findLanguage(Long id) {
		// optional can hold another object or hold null
		Optional<Language> optionalLanguage = langRepo.findById(id);
		if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
	}
	
}

