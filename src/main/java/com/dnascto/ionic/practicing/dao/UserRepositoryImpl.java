package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

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

    public User login(String loginName, String password) {
        return userRepository.login(loginName, password);
    }

    public User login(String loginName) {
        return userRepository.login(loginName);
    }
}
