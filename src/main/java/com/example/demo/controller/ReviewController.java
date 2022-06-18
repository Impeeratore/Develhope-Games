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

    @GetMapping("")
    public List<Review> reviews(){
        return reviewsService.listAllReviews();
    }

    @GetMapping("/{id}")
    public Review get(@PathVariable Integer id){
        return reviewsService.getReviews(id);
    }

    @PutMapping("/{id}")
    public Review update(@RequestBody Review review, @PathVariable Integer id) { return reviewsService.updateReview(review); }

    @PostMapping("")
    public void add(@RequestBody Review reviews){
        reviewsService.saveReviews(reviews);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        reviewsService.deleteReviews(id);
    }
}
