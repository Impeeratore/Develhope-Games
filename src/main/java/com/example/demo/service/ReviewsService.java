package com.example.demo.service;

import com.example.demo.model.Reviews;
import com.example.demo.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReviewsService {

        @Autowired
        private ReviewsRepository reviewsRepository;
        public List<Reviews> listAllReviews(){
            return reviewsRepository.findAll();
        }

        public List<Reviews> saveReviews(Reviews reviews){
            return reviewsRepository.findAll();
        }


        public Reviews getReviews(Integer id){
            return reviewsRepository.findById(id).get();
        }

        public void deleteReviews(Integer id){
             reviewsRepository.deleteById(id);
        }
}
