package com.dnascto.ionic.practicing.JWT.service;

import com.dnascto.ionic.practicing.service.UserService;
import com.dnascto.ionic.practicing.JWT.config.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Autowired
    WebSecurityConfig webSecurityConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.dnascto.ionic.practicing.model.User user = userService.login(username);

        if(user != null) {
            return new User(user.getCpf(), webSecurityConfig.passwordEncoder().encode(user.getPassword()), new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not Found");
        }
    }
}
