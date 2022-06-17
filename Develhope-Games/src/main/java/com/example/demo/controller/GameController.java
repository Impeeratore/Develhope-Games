package com.example.demo.controller;

import com.example.demo.model.Game;
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
            Game user = gameService.getGame(id);
            return new ResponseEntity<Game>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody Game game) {
        gameService.saveGame(game);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Game user, @PathVariable Integer id) {
        try {
            Game  existsGame = gameService.getGame(id);
            user.setGameId(id);
            gameService.saveGame(user);
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
