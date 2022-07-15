package com.example.demo.repository;

import com.example.demo.model.UserGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserGameRepository extends JpaRepository<UserGame, Integer> {

    @Query(value = "DELETE FROM UserGame ug WHERE ug.game = :gameId and ug.user = :userId", nativeQuery = true)
    public void deleteGameFromUser(int gameId, int userId);
}
