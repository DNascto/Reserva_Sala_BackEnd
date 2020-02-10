package com.dnascto.ionic.practicing.service;

import com.dnascto.ionic.practicing.dao.UserRepositoryImpl;
import com.dnascto.ionic.practicing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepositoryImpl userRepository;

    public User findById(int id){
        return userRepository.findById(id);
    }

    public User createUser(User user){
        return userRepository.createUser(user);
    }

    public User editUser(User user){
        return userRepository.editUser(user);
    }
}
