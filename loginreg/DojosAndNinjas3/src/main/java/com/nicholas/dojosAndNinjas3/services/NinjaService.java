package com.nicholas.dojosAndNinjas3.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicholas.dojosAndNinjas3.models.Ninja;
import com.nicholas.dojosAndNinjas3.repositories.NinjaRepository;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;
    
    //----------------register ninja and hash their password-----------//
    public Ninja registerNinja(Ninja ninja) {
    	
        String hashed = BCrypt.hashpw(ninja.getPassword(), BCrypt.gensalt());
        ninja.setPassword(hashed);
        
        return ninjaRepository.save(ninja);
    }

    //-----------find ninja by email-----------//
    public Ninja findByEmail(String email) {
        return ninjaRepository.findByEmail(email);
    }
    
    //---------------find ninja by id----------------//
    public Ninja findNinjaById(Long id) {
    	//we put optional because we don't know if the id exists. It might exist or might be null
    	Optional<Ninja> u = ninjaRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    //-------------authenticate ninja--------------//
    public boolean authenticateNinja(String email, String password) {
        // first find the ninja by email
        Ninja ninja = ninjaRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(ninja == null) {
            return false;
        } else {
        	//-------- if the passwords match, return true, else, return false-------//
            if(BCrypt.checkpw(password, ninja.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}

