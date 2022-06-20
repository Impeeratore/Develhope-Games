package com.example.demo.controller;

import com.example.demo.model.Review;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewsService;

    //region GetMapping
    @GetMapping("")
    public List<Review> reviews(){
        return reviewsService.listAllReviews();
    }

    @GetMapping("/{id}")
    public Review get(@PathVariable Integer id){ return reviewsService.getReview(id); }

    @GetMapping("/allvotesaverage")
    public double getVotes() { return reviewsService.getAverageAllVotes(); }

    @GetMapping("/avgvotes/{id}")
    public List<Review> averageVotesByGame(@PathVariable Integer id) { return reviewsService.getAverageVoteByGameId(id); }

    @GetMapping("/votes/{id}")
    public List<Review> votesByGame(@PathVariable Integer id) { return reviewsService.getVotesByGameId(id); }

    @GetMapping("/votes")
    public List<Review> allVotesGames() { return reviewsService.getAllVotes(); }

    @GetMapping("/game/{id}")
    public List<Review> getReviewByGameId(@PathVariable Integer id) { return reviewsService.getReviewByGameId(id); }

    @GetMapping("/user/{id}")
    public List<Review> getReviewByUserId(@PathVariable Integer id) { return reviewsService.getReviewByUserId(id); }

//endregion

    @PostMapping("")
    public void addNewReview(@RequestParam Integer gameId, @RequestParam Integer userId, @RequestBody Review reviews) { reviewsService.addReviewToGame(gameId, userId, reviews);}

    @PutMapping("/{id}")
    public Review update(@RequestBody Review review, @PathVariable Integer id) { return reviewsService.updateReview(review); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        reviewsService.deleteReviews(id);
    }

}
