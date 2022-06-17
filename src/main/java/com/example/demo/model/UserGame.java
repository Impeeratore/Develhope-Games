package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table (name="userGame")
public class UserGame {

    public UserGame(){}

    public UserGame(int id, Game game, User user) {
        this.id = id;
        this.game = game;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name= "fk_game")
    private Game game;

    @ManyToOne
    @JoinColumn (name= "fk_user")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
