package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {
    private int game_id;
    private String gameName;
    private String description;
    private String developer;
    private double price;
    private Date releaseDate;
    private String category;
    private String language;
    private String systemRequirements;

    public Game() {
    }

    public Game(int id, String name, String description, String developer, double price, Date release_date, String category, String lang, String system_requirements ) {
        this.game_id = id;
        this.gameName = name;
        this.description=description;
        this.developer=developer;
        this.price=price;
        this.releaseDate =release_date;
        this.category=category;
        this.language=lang;
        this.systemRequirements =system_requirements;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getGame_id() {
        return game_id;
    }

    public String getGameName() {
        return gameName;
    }

    public String getDescription() {
        return description;
    }

    public String getDeveloper() {
        return developer;
    }

    public double getPrice() {
        return price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getCategory() {
        return category;
    }

    public String getLanguage() {
        return language;
    }

    public String getSystemRequirements() {
        return systemRequirements;
    }
    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setSystemRequirements(String systemRequirements) {
        this.systemRequirements = systemRequirements;
    }

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "game")
    @Column (nullable = false)
    private List<Review> reviews;



}
