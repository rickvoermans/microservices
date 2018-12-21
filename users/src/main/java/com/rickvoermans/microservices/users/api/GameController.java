package com.rickvoermans.microservices.users.api;

import com.rickvoermans.microservices.users.api.models.Game;
import com.rickvoermans.microservices.users.api.models.data_transfer_objects.GameDto;
import com.rickvoermans.microservices.users.api.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "games")
public class GameController {

    private GameRepository gameRepository;

    @Autowired
    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @PostMapping
    public void addToFavourites(@RequestBody GameDto gameDto) throws Exception {
        boolean inFavourites = gameRepository.findGameInList(gameDto.getUserId(), gameDto.getGameId()).isPresent();

        if (!inFavourites) {
            Game game = new Game();
            game.setDate(gameDto.getDateAdded());
            game.setUserId(gameDto.getUserId());
            game.setGameId(gameDto.getGameId());
            game.setGame(gameDto.getGame());

            gameRepository.save(game);
        } else {
            throw new Exception(gameDto.getGame() + " is already in your favourite list");
        }
    }

    @GetMapping
    public List<Game> getFavouriteGames() {
        List<Game> games = new ArrayList<>();
        gameRepository.findAll().forEach(games::add);

        return games;
    }
}
