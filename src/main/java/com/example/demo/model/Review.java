package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    private int reviewId;
    private int stars;
    private String comments;

    public Review(){
    }

    public Review(int stars, String comments) {
        this.stars = stars;
        this.comments = comments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getReviewId() {
        return reviewId;
    }

    public int getStars() {
        return stars;
    }

    public String getComments() {
        return comments;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToOne
    private Game game;
}
