package com.example.demo.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;
    private double votes;

    @ManyToOne
    @JoinColumn(name = "fk_game")
    private Game game;

    @ManyToOne
    @JoinColumn (name = "fk_user")
    private User user;

    //region Costruttori
    public Review() {}

    public Review(int id, String comment, int stars, Game game) {
        this.id = id;
        this.comment = comment;
        this.votes = stars;
        this.game = game;
    }
//endregion

    //region Getter e Setter
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

    public double getVotes() { return votes; }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public void setGame(Game game) { this.game = game; }

    public void setUser(User user) { this.user = user; }

    //endregion

}
