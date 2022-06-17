package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.model.Review;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/review")
public class ReviewsController {
    @Autowired
    ReviewService reviewsService;

    @GetMapping("")
    public List<Review> reviews(){
        return reviewsService.listAllReviews();
    }
    @GetMapping("/{id}")
    public Review get(@PathVariable Integer id){
        return reviewsService.getReviews(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Review review, @PathVariable Integer id) {
        try {
            Review  existsReview = reviewsService.getReviews(id);
            review.setId(id);
            reviewsService.saveReviews(review);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody Review reviews){
        reviewsService.saveReviews(reviews);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        reviewsService.deleteReviews(id);
    }
}
