package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    GameService gameService;

    //region GetMapping
    @GetMapping("")
    public List<Game> listAllGames() { return gameService.listAllGames();}

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Integer id) { return  gameService.getGame(id); }

    @GetMapping("/user/{id}")
    public List<Game> getGamesByUser(@PathVariable Integer id) { return  gameService.getGamesByUser(id); }

//endregion

    @PostMapping("")
    public void saveGame(@RequestBody Game game) { gameService.saveGame(game); }

    @PutMapping("")
    public Game updateGame(@RequestBody Game game) { return gameService.updateGame(game); }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Integer id) { gameService.deleteGame(id); }

}
