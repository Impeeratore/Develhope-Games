package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;
    private int stars;

    @ManyToOne
    @JoinColumn(name = "fk_game")
    private Game game;

    @ManyToOne
    @JoinColumn (name = "fk_user")
    private User user;

    public Review(int id, String comment, int stars, Game game) {
        this.id = id;
        this.comment = comment;
        this.stars = stars;
        this.game = game;
    }

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
