package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    //region CRUD
    public List<User> listAllUsers() { return userRepository.findAll(); }

    public void saveUser(User user) { userRepository.save(user); }

    public ResponseEntity<User> getUser(Integer id) {
        try {
            User user = userRepository.findById(id).get();
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteUser (Integer id) { userRepository.deleteById(id); }

    public User updateUser (User user) { return userRepository.saveAndFlush(user); }
//endregion

    //region Metodi Extra

    public List<User> getUserByGameId(Integer id) { return userRepository.getUserByGameId(id); }

//endregion

}

