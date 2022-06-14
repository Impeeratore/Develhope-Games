package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.model.Review;
import com.example.demo.repository.GameRepository;
import com.example.demo.service.GameService;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @Autowired
    GameService gameService;


    /*
    --- VIEW REVIEWS ---
     */

    /*
    Basic listing of all reviews
     */
    @GetMapping("")
    public List<Review> list() {
        return reviewService.listAllReviews();
    }

    /*
    Basic get of a single review by its id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Review> get(@PathVariable Integer id) {
        try {
            Review review = reviewService.getReview(id);
            return new ResponseEntity<Review>(review, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
        }
    }

    /*
    List all the reviews for a specific Game
     */
    @GetMapping("/getAllByGameId")
    public List<String> getAllReviewsByGameId(@RequestParam int gameId) {
        List<Review> reviews =  gameService.getGame(gameId).getReviews();
        List<String> comments = new ArrayList<>();
        for(Review r : reviews) {
            comments.add(r.getComment());
        }
        return comments;
    }

    @GetMapping("/getAllByValue")
    public List<String> getAllByValue(
            @RequestParam int gameId,
            @RequestParam int value
            ) {
        List<Review> reviews =  gameService.getGame(gameId).getReviews();
        List<String> comments = new ArrayList<>();
        for(Review r : reviews) {
            if (r.getValue() == value) {
                comments.add(r.getComment());
            }
        }
        return comments;
    }


    /*
    INSERT REVIEWS
     */

    /*
    Manually add a new review
     */
    @PostMapping("/")
    public void add(@RequestBody Review review) {
        reviewService.saveReview(review);
    }

    /*
    Manually update a review
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Review review, @PathVariable Integer id) {
        try {
            Review  existsReview = reviewService.getReview(id);
            review.setReviewId(id);
            reviewService.saveReview(review);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
    Publish a new review
     */

    @PostMapping("/publishNewReview")
    public void publishNewReview(
            @RequestParam int gameId,
            //@RequestParam int userId,
            @RequestParam String comment,
            @RequestParam int value
    ) {
       Review newReview = new Review(comment, value);
       reviewService.saveReview(newReview);
       reviewService.addGameToReview(newReview.getReviewId(), gameId);
    }


    /*
    Delete a review by its id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        reviewService.deleteReview(id);
    }

}
