package com.example.demo.service;

import com.example.demo.model.Game;
import com.example.demo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> listAllGames() { return gameRepository.findAll(); }

    public void saveGame(Game game) { gameRepository.save(game); }

    public Game getGame(Integer id){ return gameRepository.findById(id).get(); }

    public void deleteGame(Integer id) {gameRepository.deleteById(id);}

    public Game updateGame(Game game) {
        game.setId(game.getId());
        Game newGame = gameRepository.saveAndFlush(game);
        return newGame; }


        /*public double getAverageStar(Integer id){
        List<Integer> starsList = new ArrayList<>();
        starsList.add(review.getStars());
        int sum = 0;
        for (int i=0; i < starsList.size(); i++ ){
            sum = sum + starsList.get(i);
        }
        return sum/starsList.size();
    }*/
}

