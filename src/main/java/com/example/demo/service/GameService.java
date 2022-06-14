package com.example.demo.service;

import com.example.demo.model.Game;
import com.example.demo.model.Review;
import com.example.demo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    // @Autowired
    // private ReviewService reviewService;

    public List<Game> listAllGames() {
        return gameRepository.findAll();
    }

    public void saveGame(Game user) {
        gameRepository.save(user);
    }

    public Game getGame(Integer id) {
        return gameRepository.findById(id).get();
    }

    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }

/*    public void addReviewToGame(int gameId, int reviewId) {
        Review review = reviewService.getReview(reviewId);
        Game game = getGame(gameId);
        game.addReview(review);
        saveGame(game);
    }*/
}
