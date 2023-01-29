package com.linkbox.linkbox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkbox.linkbox.dao.UserDao;
import com.linkbox.linkbox.models.User;

@Service
public class UserService {
    
    @Autowired
    UserDao userDao;

    public List<User> getUsers() {
        return userDao.findAll();
    }

    public boolean createUser(User user) {
        try {
            userDao.save(user);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean updateUser(User user) {
        try {
            userDao.saveAndFlush(user);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean deleteUser(Long id) {
        try {
            userDao.deleteById(id);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}