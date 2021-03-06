package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.cpf = :loginName or u.nickname = :loginName and u.password = :pwd")
    User login(@Param("loginName") String loginName, @Param("pwd") String password);

    @Query("SELECT u FROM User u WHERE u.cpf = :loginName or u.nickname = :loginName")
    User login(@Param("loginName") String loginName);

}
