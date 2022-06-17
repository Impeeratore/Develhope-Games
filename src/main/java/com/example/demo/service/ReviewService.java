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

    public List<Review> listAllReviews(){
        return reviewsRepository.findAll();
    }

    public void saveReviews(Review review){
        reviewsRepository.save(review);
    }

    public Review getReviews(Integer id){
        return reviewsRepository.findById(id).get();
    }

    public void deleteReviews(Integer id){
        reviewsRepository.deleteById(id);
    }
}
