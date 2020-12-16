package com.nicholas.authentication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.nicholas.authentication.models.User;

//----------------This method retrieves a specific user by their email---------------//

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
