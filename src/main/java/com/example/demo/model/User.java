package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String playerName;
    private String mail;
    private Date birth;
    private String subscription;
    private double userWallet;
    private String country;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;


    public User(int id, String name, String surname, String playerName, String mail, Date birth, String subscription, double user_wallet, String country) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.playerName = playerName;
        this.mail = mail;
        this.birth = birth;
        this.subscription = subscription;
        this.userWallet = user_wallet;
        this.country = country;
    }

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public double getUserWallet() {
        return userWallet;
    }

    public void setUserWallet(double userWallet) {
        this.userWallet = userWallet;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
