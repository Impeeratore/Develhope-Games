package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value= "SELECT * FROM user u JOIN user_game ug ON u.id = ug.fk_user JOIN game g ON ug.fk_game=g.id WHERE g.id = :gameId", nativeQuery=true)
    public List<User> getUserByGameId(Integer gameId);

}
