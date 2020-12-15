package com.nicholas.dojosAndNinjas.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicholas.dojosAndNinjas.models.Ninja;

//---------------- Dojo represents the object and Long represents the id --------------//
@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}
