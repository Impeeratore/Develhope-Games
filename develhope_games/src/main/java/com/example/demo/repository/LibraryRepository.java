package com.example.demo.repository;

import com.example.demo.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

    @Query(value = "DELETE FROM UserGame ug WHERE ug.game = :gameId and ug.user = :userId", nativeQuery = true)
    public void deleteGameFromUser(int gameId, int userId);
}
