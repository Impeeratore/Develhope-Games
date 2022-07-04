package com.example.demo.repository;

import com.example.demo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query(value = "SELECT avg (r.votes) FROM review r JOIN game g ON r.fk_game=g.id WHERE g.id= :gameId", nativeQuery = true)
    public Integer getAverageVoteByGameId(Integer gameId);

    @Query(value = "SELECT r.votes FROM review r JOIN game g ON r.fk_game=g.id WHERE g.id = :gameId", nativeQuery = true)
    public List<Integer> getVotesByGameId(Integer gameId);

    @Query(value = "SELECT r.votes FROM review r JOIN game g ON r.fk_game=g.id", nativeQuery = true)
    public List<Integer> getAllVotes();

    @Query(value = "SELECT * FROM review r JOIN game g ON r.fk_game=g.id WHERE g.id = :gameId", nativeQuery = true)
    public List<Review> getReviewByGameId(Integer gameId);

    @Query(value = "SELECT * FROM review r JOIN user u ON u.id=r.fk_user JOIN game g ON g.id=r.fk_game WHERE u.id =:userId", nativeQuery = true)
    public List<Review> getReviewByUserId(Integer userId);


}