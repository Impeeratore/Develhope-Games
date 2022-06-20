package com.example.demo.service;

import com.example.demo.model.Game;
import com.example.demo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private EntityManager entityManager;

    //region  CRUD
    public List<Game> listAllGames() {
        return gameRepository.findAll();
    }

    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    public Game getGame(Integer id) { return gameRepository.findById(id).get(); }

    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }

    public Game updateGame(Game game) {
        game.setId(game.getId());
        Game newGame = gameRepository.saveAndFlush(game);
        return newGame;
    }
//endregion

    //region Metodi Extra
    public List<Game> getGamesByUser(Integer id) {
        Query query = entityManager.createQuery("SELECT g FROM UserGame ug JOIN ug.game g JOIN ug.user u WHERE u.id = '" + id + "'");
        List<Game> resultList = query.getResultList();
        return resultList;}
//endregion


}

