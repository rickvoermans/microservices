package com.rickvoermans.microservices.users.api.repository;

import com.rickvoermans.microservices.users.api.models.User;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<User, Long> { }
