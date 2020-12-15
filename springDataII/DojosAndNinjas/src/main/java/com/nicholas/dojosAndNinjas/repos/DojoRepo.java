package com.nicholas.dojosAndNinjas.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicholas.dojosAndNinjas.models.Dojo;

//---------------- Dojo represents the object and Long represents the id --------------//
@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
}
