package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryImpl {
    @Autowired
    private UserRepository userRepository;

    public User findById(int id){
        return userRepository.getOne(id);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User editUser(User user){
        return userRepository.save(user);
    }
}
