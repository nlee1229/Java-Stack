package com.nicholas.dojosAndNinjas3.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicholas.dojosAndNinjas3.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	Ninja findByEmail(String email);
	
}
