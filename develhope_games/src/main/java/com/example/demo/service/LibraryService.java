package com.example.demo.service;

import com.example.demo.model.Game;
import com.example.demo.model.User;
import com.example.demo.model.Library;
import com.example.demo.repository.GameRepository;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Transactional
@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;


    public void addGameToUser(int gameId, int userId, Library library){
        Game game = gameRepository.findById(gameId).get();
        User user = userRepository.findById(userId).get();
        library.setGame(game);
        library.setUser(user);
        libraryRepository.save(library); }

    public void deleteGameFromUser(Integer gameId, Integer userId) { libraryRepository.deleteGameFromUser(gameId, userId); }

    }


