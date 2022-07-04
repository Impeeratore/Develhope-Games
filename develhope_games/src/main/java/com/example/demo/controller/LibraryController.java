package com.example.demo.controller;

import com.example.demo.model.Library;
import com.example.demo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping
    public void addGameToUser(@RequestParam Integer gameId, @RequestParam Integer userId) { libraryService.addGameToUser(gameId, userId, new Library()); }

    @DeleteMapping
    public void deleteGameFromUser(@RequestParam Integer gameId, @RequestParam Integer userId) { libraryService.deleteGameFromUser(gameId, userId); }

}
