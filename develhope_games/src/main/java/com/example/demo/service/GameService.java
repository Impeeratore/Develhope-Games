package com.example.demo.service;

import com.example.demo.model.Game;
import com.example.demo.model.Review;
import com.example.demo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;


    //region  CRUD
    public List<Game> listAllGames() {
        return gameRepository.findAll();
    }

    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    public ResponseEntity<Game> getGame(Integer id) {
        try {
            Game game = gameRepository.findById(id).get();
            return new ResponseEntity<Game>(game, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }

    public Game updateGame(Game game) {
        return gameRepository.saveAndFlush(game);
    }
//endregion

    //region Metodi Extra
    public List<Game> getGamesByUser(Integer id) { return gameRepository.getGamesByUser(id); }
//endregion

}

