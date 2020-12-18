package com.nicholas.dojosAndNinjas3.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nicholas.dojosAndNinjas3.models.Ninja;

@Component
public class NinjaValidator implements Validator {
    
    // 1
    @Override
    public boolean supports(Class<?> clazz) {
        return Ninja.class.equals(clazz);
    }
    
    // 2
    
    @Override
    public void validate(Object target, Errors errors) {
        Ninja ninja = (Ninja) target;
        
        if (!ninja.getPasswordConfirmation().equals(ninja.getPassword())) {
            // 3                  key                    value
            errors.rejectValue("passwordConfirmation", "Match");
	        }         
	    }
	}


