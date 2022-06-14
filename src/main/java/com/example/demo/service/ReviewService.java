package com.example.demo.service;

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
    private ReviewRepository reviewsRepository;

    public List<Review> listAllReview() {
        return reviewsRepository.findAll();
    }

    public void saveReview(Review game) {
        reviewsRepository.save(game);
    }

    public Review getReview(Integer id) {
        return reviewsRepository.findById(id).get();
    }

    public void deleteReview(Integer id) {
        reviewsRepository.deleteById(id);
    }

}
