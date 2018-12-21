package com.rickvoermans.microservices.games.api;

import com.rickvoermans.microservices.games.api.models.Company;
import com.rickvoermans.microservices.games.api.models.Game;
import com.rickvoermans.microservices.games.api.models.GameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "games")
public class GamesController {

    private GameRepository gameRepository;

    @Autowired
    public GamesController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

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
    public Game addGame(@RequestBody GameDto gameDto) throws Exception {
        boolean existingGame = gameRepository.findByTitle(gameDto.getTitle()).isPresent();

        // todo: simplify code
        if (!existingGame) {
            // create game
            Game game = new Game();
            game.setTitle(gameDto.getTitle());
            game.setDescription(gameDto.getDescription());
            game.setMinimumAge(gameDto.getMinimumAge());
            game.setRating(gameDto.getRating());
            game.setReleaseDate(gameDto.getReleaseDate());
            game.setPrice(gameDto.getPrice());

            // create company
            ArrayList<String> games = new ArrayList<>();
            games.add("csgo");
            games.add("team fortress");
            Company company = new Company();
            company.setName("test");
            company.setFounded(LocalDate.now());
            company.setDeveloped(games);

            // set company and game
            game.setCompany(company);
            company.setGame(game);

            gameRepository.save(game);
            return game;
        } else {
            throw new Exception("Game: " + gameDto.getTitle() + " already exists");
        }

    }

    @PostMapping("/add/favourites")
    public void addGameToFavourites(@RequestBody GameDto gameDto) {
        HttpEntity<GameDto> request = new HttpEntity<>(gameDto);
    }
}
