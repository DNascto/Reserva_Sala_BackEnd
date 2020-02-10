package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
