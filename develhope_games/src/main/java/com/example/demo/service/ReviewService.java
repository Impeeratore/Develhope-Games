package com.example.demo.service;

import com.example.demo.model.Game;
import com.example.demo.model.Review;
import com.example.demo.model.User;
import com.example.demo.repository.GameRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewsRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    //region CRUD
    public List<Review> listAllReviews() {
            return reviewsRepository.findAll();
            }

    public ResponseEntity<Review> getReview(Integer id) {
        try {
            Review review = reviewsRepository.findById(id).get();
            return new ResponseEntity<Review>(review, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteReviews(Integer id) {
        reviewsRepository.deleteById(id);
    }

    public Review updateReview(Review review) { return reviewsRepository.saveAndFlush(review); }
//endregion

    //region Metodi Extra

    public double getAverageAllVotes() {
        List<Double> votesList = new ArrayList<>();
        List<Review> reviewList = reviewsRepository.findAll();
        for (Review review : reviewList) {
            votesList.add(review.getVotes());
        }
        double somma = 0;
        for (int i = 0; i < votesList.size(); i++) {
            somma = somma + votesList.get(i);
        }
        return somma / votesList.size();
    }

    public void addReviewToGame(int gameId, int userId, Review review){
        Game game = gameRepository.findById(gameId).get();
        User user = userRepository.findById(userId).get();
        review.setGame(game);
        review.setUser(user);
        reviewsRepository.save(review); }

    public int getAverageVoteByGameId(Integer id) { return reviewsRepository.getAverageVoteByGameId(id); }

    public List<Integer> getVotesByGameId(Integer id) { return reviewsRepository.getVotesByGameId(id); }

    public List<Integer> getAllVotes() { return reviewsRepository.getAllVotes(); }

    public List<Review> getReviewByGameId(Integer id) { return reviewsRepository.getReviewByGameId(id); }

    public List<Review> getReviewByUserId(Integer id) { return reviewsRepository.getReviewByUserId(id); }

//endregion


}

