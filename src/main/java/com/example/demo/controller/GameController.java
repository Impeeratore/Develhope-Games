package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    GameService gameService;

    //region GetMapping
    @GetMapping("")
    public List<Game> list() {return gameService.listAllGames();}

    @GetMapping("/{id}")
    public Game get(@PathVariable Integer id) { return  gameService.getGame(id); }

    @GetMapping("/user/{id}")
    public List<Game> getGamesByUser(@PathVariable Integer id) { return  gameService.getGamesByUser(id); }

//endregion

    @PostMapping("")
    public void add(@RequestBody Game game) {
        gameService.saveGame(game);
    }

    @PutMapping("/{id}")
    public Game update(@RequestBody Game game, @PathVariable Integer id) { return gameService.updateGame(game); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { gameService.deleteGame(id); }

}
