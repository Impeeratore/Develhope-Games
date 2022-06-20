package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table (name="userGame")
public class UserGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name= "fk_game")
    private Game game;

    @ManyToOne
    @JoinColumn (name= "fk_user")
    private User user;

    //region Costruttori
    public UserGame(){}

    public UserGame(int id, Game game, User user) {
        this.id = id;
        this.game = game;
        this.user = user;
    }
//endregion

    //region Getter e Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game getGame(Game game) { return game; }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser(User user) {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
//endregion

}
