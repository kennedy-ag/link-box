package com.linkbox.linkbox.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.linkbox.linkbox.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    @Query(value = "select * from user where username = :username", nativeQuery = true)
    List<User> findByUsername(@Param("username") String username);
}