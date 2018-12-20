package com.rickvoermans.microservices.users.api.repository;

import com.rickvoermans.microservices.users.api.models.User;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<User, Long> { }
