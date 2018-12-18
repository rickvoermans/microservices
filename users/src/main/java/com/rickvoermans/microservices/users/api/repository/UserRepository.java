package com.rickvoermans.microservices.users.api.repository;

import com.rickvoermans.microservices.users.api.UserController;
import com.rickvoermans.microservices.users.api.models.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

}
