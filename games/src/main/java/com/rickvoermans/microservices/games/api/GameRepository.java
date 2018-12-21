package com.rickvoermans.microservices.games.api;

import com.rickvoermans.microservices.games.api.models.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GameRepository extends CrudRepository<Game, Long> {

    Optional<Game> findByTitle(String title);

}
