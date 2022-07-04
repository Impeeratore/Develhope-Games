package com.example.demo.controller;

import com.example.demo.model.Review;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewsService;

    //region GetMapping
    @GetMapping("")
    public List<Review> listAllReviews(){
        return reviewsService.listAllReviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReview(@PathVariable Integer id){ return reviewsService.getReview(id); }

    @GetMapping("/allvotesaverage")
    public double getAverageAllVotes() { return reviewsService.getAverageAllVotes(); }

    @GetMapping("/avgvotes/{id}")
    public Integer getAverageVoteByGameId(@PathVariable Integer id) { return reviewsService.getAverageVoteByGameId(id); }

    @GetMapping("/votes/{id}")
    public List<Integer> getVotesByGameId(@PathVariable Integer id) { return reviewsService.getVotesByGameId(id); }

    @GetMapping("/votes")
    public List<Integer> getAllVotes() { return reviewsService.getAllVotes(); }

    @GetMapping("/game/{id}")
    public List<Review> getReviewByGameId(@PathVariable Integer id) { return reviewsService.getReviewByGameId(id); }

    @GetMapping("/user/{id}")
    public List<Review> getReviewByUserId(@PathVariable Integer id) { return reviewsService.getReviewByUserId(id); }

//endregion

    @PostMapping("")
    public void addReviewToGame(@RequestParam Integer gameId, @RequestParam Integer userId, @RequestBody Review reviews) { reviewsService.addReviewToGame(gameId, userId, reviews); }

    @PutMapping("")
    public Review updateReview(@RequestBody Review review) { return reviewsService.updateReview(review); }

    @DeleteMapping("/{id}")
    public void deleteReviews(@PathVariable Integer id) {
        reviewsService.deleteReviews(id);
    }

}
