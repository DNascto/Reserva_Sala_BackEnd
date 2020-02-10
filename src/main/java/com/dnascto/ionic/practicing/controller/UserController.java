package com.dnascto.ionic.practicing.controller;

import com.dnascto.ionic.practicing.model.User;
import com.dnascto.ionic.practicing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:8100")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUserById(@RequestParam int id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/user")
    public ResponseEntity<User> editUser(@RequestBody User user){
        return ResponseEntity.ok(userService.editUser(user));
    }

}
