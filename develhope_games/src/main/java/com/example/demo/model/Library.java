package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "library")
    private List<Game> gameList;

    @OneToOne
    @JoinColumn (name= "user_id")
    private User user;

    //region Constructor

    public Library() {
    }

    public Library(int id, List<Game> gameList, User user) {
        this.id = id;
        this.gameList = gameList;
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

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGame(Game game) {
    }



//endregion

}
