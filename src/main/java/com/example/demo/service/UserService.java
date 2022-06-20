package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    //region CRUD
    public List<User> listAllUsers() { return userRepository.findAll(); }

    public void saveUser(User user) { userRepository.save(user); }

    public User getUser(Integer id) { return userRepository.findById(id).get();}

    public void deleteUser (Integer id){ userRepository.deleteById(id); }

    public User updateUser (User user){
            user.setId(user.getId());
            User newUser = userRepository.saveAndFlush(user);
            return newUser;
        }
//endregion

    //region MetodiExtra
    public List<User> getUserByGameId(Integer id) {
        Query query = entityManager.createQuery("SELECT u FROM UserGame ug JOIN ug.user u JOIN ug.game g WHERE g.id = '"+id+"'");
        List<User> resultList = query.getResultList();
        return resultList;
    }
//endregion


}

