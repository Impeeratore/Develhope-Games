package com.example.demo.repository;

import com.example.demo.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query(value= "SELECT * FROM game g JOIN user_game ug ON g.id = ug.fk_game JOIN user u ON ug.fk_user= u.id WHERE u.id = :userId", nativeQuery = true)
    public List<Game> getGamesByUser(Integer userId);
}
