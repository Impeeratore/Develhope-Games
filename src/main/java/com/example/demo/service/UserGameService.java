package com.example.demo.service;

import com.example.demo.model.Game;
import com.example.demo.model.User;
import com.example.demo.model.UserGame;
import com.example.demo.repository.GameRepository;
import com.example.demo.repository.UserGameRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
@Service
public class UserGameService {

    @Autowired
    private UserGameRepository userGameRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;


    public void addGameToUser(int gameId, int userId, UserGame library){
        Game game = gameRepository.findById(gameId).get();
        User user = userRepository.findById(userId).get();
        library.setGame(game);
        library.setUser(user);
        userGameRepository.save(library); }

    public void deleteGameFromUser(int gameId, int userId) {
        Query query = entityManager.createQuery("DELETE FROM UserGame ug WHERE ug.game = '"+gameId+"' and ug.user = '"+userId+"'");
        query.executeUpdate();

        }

    }


