package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.model.Review;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping("")
    public List<Game> list() {
        return gameService.listAllGames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> get(@PathVariable Integer id) {
        try {
            Game game = gameService.getGame(id);
            return new ResponseEntity<Game>(game, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/reviews")
    public List<Review> getGameReviews(@PathVariable int id) {
        return gameService.getGame(id).getReviews();
    }

    @PostMapping("/")
    public void add(@RequestBody Game game) {
        gameService.saveGame(game);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Game game, @PathVariable Integer id) {
        try {
            Game  existsGame = gameService.getGame(id);
            game.setGameId(id);
            gameService.saveGame(game);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        gameService.deleteGame(id);
    }
}
