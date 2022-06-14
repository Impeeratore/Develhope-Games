package com.example.demo.controller;

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
public class ReviewController {

    @Autowired
    ReviewService reviewsService;

    @GetMapping("")
    public List<Review> list() {
        return reviewsService.listAllReview();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> get(@PathVariable Integer id) {
        try {
            Review game = reviewsService.getReview(id);
            return new ResponseEntity<Review>(game, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Review review) {
        reviewsService.saveReview(review);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Review game, @PathVariable Integer id) {
        try {
            Review  existsReview = reviewsService.getReview(id);
            game.setReviewId(id);
            reviewsService.saveReview(game);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        reviewsService.deleteReview(id);
    }
}
