package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //region GetMapping
    @GetMapping("")
    public List<User> userList(){ return userService.listAllUsers(); }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id){ return userService.getUser(id); }

    @GetMapping("/game/{id}")
    public List<User> getUserByGameId(@PathVariable Integer id) { return userService.getUserByGameId(id); }
//endregion

    @PostMapping("")
    public void addUser(@RequestBody User user){ userService.saveUser(user); }

    @PutMapping("")
    public User update(@RequestBody User user) { return userService.updateUser(user); }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

}
