package com.example.demo.service;

import com.example.demo.model.Game;
import com.example.demo.model.Review;
import com.example.demo.model.User;
import com.example.demo.repository.GameRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewsRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    //region CRUD
    public List<Review> listAllReviews() { return reviewsRepository.findAll(); }

    public void addReviewToGame(int gameId, int userId, Review review){
        Game game = gameRepository.findById(gameId).get();
        User user = userRepository.findById(userId).get();
        review.setGame(game);
        review.setUser(user);
        reviewsRepository.save(review); }

    public Review getReview(Integer id) { return reviewsRepository.findById(id).get(); }

    public void deleteReviews(Integer id) {
        reviewsRepository.deleteById(id);
    }

    public Review updateReview(Review review) {
        review.setId(review.getId());
        Review newReview = reviewsRepository.saveAndFlush(review);
        return newReview;
    }
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

    public List<Review> getAverageVoteByGameId(Integer id) {
        Query query = entityManager.createQuery("SELECT avg (r.votes) FROM Review r JOIN r.game rg WHERE rg.id = '"+id+"'");
        List<Review> resultList = query.getResultList();
        return resultList;
    }

    public List<Review> getVotesByGameId(Integer id) {
        Query query = entityManager.createQuery("SELECT r.votes FROM Review r JOIN r.game rg WHERE rg.id = '"+id+"'");
        List<Review> resultList = query.getResultList();
        return resultList;
    }

    public List<Review> getAllVotes() {
        Query query = entityManager.createQuery("SELECT r.votes FROM Review r JOIN r.game rg");
        List<Review> resultList = query.getResultList();
        return resultList;
    }

        public List<Review> getReviewByGameId(Integer id) {
            Query query = entityManager.createQuery("SELECT r FROM Review r JOIN r.game rg WHERE rg.id = '"+id+"'");
            List<Review> resultList = query.getResultList();
            return resultList;
    }

    public List<Review> getReviewByUserId(Integer id) {
        Query query = entityManager.createQuery("SELECT r, rg FROM Review r JOIN r.user ru JOIN r.game rg WHERE ru.id = '"+id+"'");
        List<Review> resultList = query.getResultList();
        return resultList;
    }

//endregion


}

