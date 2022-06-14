package com.example.demo.service;

import com.example.demo.model.Game;
import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private GameService gameService;

    public List<Review> listAllReviews() {
        return reviewRepository.findAll();
    }

    public void saveReview(Review review) {
        reviewRepository.save(review);
    }

    public Review getReview(Integer id) {
        return reviewRepository.findById(id).get();
    }

    public void deleteReview(Integer id) {
        reviewRepository.deleteById(id);
    }

    public void addGameToReview(int reviewId, int gameId) {
        Review review = getReview(reviewId);
        Game game = gameService.getGame(gameId);
        review.setGame(game);
        saveReview(review);
    }
}
