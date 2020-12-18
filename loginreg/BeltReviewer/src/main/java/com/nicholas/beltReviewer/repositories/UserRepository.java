package com.nicholas.beltReviewer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicholas.beltReviewer.models.User;

//----------------This method retrieves a specific user by their email---------------//

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
