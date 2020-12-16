package com.nicholas.studentRoster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nicholas.studentRoster.models.Student;

public interface StudentRepo extends CrudRepository<Student, Long> {
	List<Student> findAll();
}
