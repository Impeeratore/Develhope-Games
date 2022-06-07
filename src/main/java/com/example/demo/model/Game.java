package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.sql.Date.*;

@Entity
@Table(name = "game")
public class Game {
    private int game_id;
    private String game_name;
    private String description;
    private String developer;
    private double price;
    private Date release_date;
    private String category;
    private String language;
    private String system_requirements;

    public Game() {
    }

    public Game(int id, String name, String description, String developer, double price, Date release_date, String category, String lang, String system_requirements ) {
        this.game_id = id;
        this.game_name = name;
        this.description=description;
        this.developer=developer;
        this.price=price;
        this.release_date=release_date;
        this.category=category;
        this.language=lang;
        this.system_requirements=system_requirements;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getGame_id() {
        return game_id;
    }

    public String getGame_name() {
        return game_name;
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

    public Date getRelease_date() {
        return release_date;
    }

    public String getCategory() {
        return category;
    }

    public String getLanguage() {
        return language;
    }

    public String getSystem_requirements() {
        return system_requirements;
    }
    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
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

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setSystem_requirements(String system_requirements) {
        this.system_requirements = system_requirements;
    }



}
