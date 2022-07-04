package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {
    //region Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String developer;
    private double price;
    private Date releaseDate;
    private String category;
    private String language;
    private String systemRequirements;
//endregion

    @OneToMany(mappedBy = "game")
    private List<Review> review;

    @ManyToOne
    private Library library;

    //region Constructor
    public Game() {
    }

    public Game(int id, String name, String description, String developer, double price, Date release_date, String category, String lang, String system_requirements ) {
        this.id = id;
        this.name = name;
        this.description=description;
        this.developer=developer;
        this.price=price;
        this.releaseDate =release_date;
        this.category=category;
        this.language=lang;
        this.systemRequirements =system_requirements;
    }
//endregion

    //region Getter e Setter
    public int getId() { return id; }

    public String getName() {
        return name;
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

    public void setId(int id) { this.id = id; }

    public void setName(String name) {
        this.name = name;
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



    //endregion
}