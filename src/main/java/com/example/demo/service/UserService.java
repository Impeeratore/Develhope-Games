package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listAllUsers(){
        return userRepository.findAll();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public User getUserById(Integer id){
        return userRepository.findById(id).get();
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
            user.setId(user.getId());
            User newUser = userRepository.saveAndFlush(user);
            return newUser; }

}
