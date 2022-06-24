package com.example.demo.controller;

import com.example.demo.model.UserGame;
import com.example.demo.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/library")
public class UserGameController {

    @Autowired
    private UserGameService userGameService;

    @PostMapping
    public void addGameToUser(@RequestParam Integer gameId, @RequestParam Integer userId) { userGameService.addGameToUser(gameId, userId, new UserGame()); }

    @DeleteMapping
    public void deleteGameFromUser(@RequestParam Integer gameId, @RequestParam Integer userId) { userGameService.deleteGameFromUser(gameId, userId); }

}
