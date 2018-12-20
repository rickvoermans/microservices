package com.rickvoermans.microservices.games.api;

import com.rickvoermans.microservices.games.api.models.Game;
import com.rickvoermans.microservices.games.api.models.GameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(name = "games")
public class GamesController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public List<Game> getGames() {
        List<Game> games = new ArrayList<>();
        gameRepository.findAll().forEach(games::add);

        return games;
    }

    @GetMapping(path = "/{id}")
    public Game getGame(@PathVariable("id") Long id) {
        return gameRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }

    @PostMapping("/add")
    public void addGame(@RequestBody GameDto gameDto) {
        HttpEntity<GameDto> request = new HttpEntity<>(gameDto);

    }
}
