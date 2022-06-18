package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> userList(){
        return userService.listAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping("")
    public void addUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable Integer id) { return userService.updateUser(user); }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

}
