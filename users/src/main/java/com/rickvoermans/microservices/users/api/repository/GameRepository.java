package com.rickvoermans.microservices.users.api.repository;

import com.rickvoermans.microservices.users.api.models.Game;
import com.rickvoermans.microservices.users.api.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GameRepository extends CrudRepository<Game, Long> {

    Optional<Game> findGameInList(Long userId, Long gameId);

}
