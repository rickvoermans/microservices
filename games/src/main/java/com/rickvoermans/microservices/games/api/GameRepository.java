package com.rickvoermans.microservices.games.api;

import com.rickvoermans.microservices.games.api.models.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> { }
