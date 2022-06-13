package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reviews")
public class Reviews {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  @Column(name = "reviews_id")
  public int getReviewsId() {
    return reviewsId;
  }

  private int reviewsId;
  private int stars;
  private String comments;
  private int gameId;
  private int userId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "game_id")
  private Game game;

  public Reviews() {

  }


  public Reviews(int reviewsId, int stars, String comments, int gameId, int userId, Game game) {
    this.reviewsId = reviewsId;
    this.stars = stars;
    this.comments = comments;
    this.gameId = gameId;
    this.userId = userId;
    this.game = game;
  }



  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public void setReviewsId(int reviewsId) {
    this.reviewsId = reviewsId;
  }

  public int getStars() {
    return stars;
  }

  public void setStars(int stars) {
    this.stars = stars;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public int getGameId() {
    return gameId;
  }

  public void setGameId(int gameId) {
    this.gameId = gameId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
