package com.linkbox.linkbox.services;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkbox.linkbox.dao.UserDao;
import com.linkbox.linkbox.models.Message;
import com.linkbox.linkbox.models.User;

@Service
public class UserService {

    Logger logger = Logger.getLogger("User logger");
    
    @Autowired
    UserDao userDao;

    public Optional<User> getUser(Integer id) {
        return userDao.findById(id);
    }

    public List<User> getUsers() {
        return userDao.findAll();
    }

    public Message createUser(User user) {
        try {
            if(isAvailableUsername(user.getUsername())){
                userDao.save(user);
                return new Message("user created");
            }
            return new Message("username is not available");
        } catch(Exception e) {
            logger.error(e.getMessage());
            return new Message("user not created: "+e.getLocalizedMessage());
        }
    }

    public boolean updateUser(Integer id, User newData) {
        newData.setUserId(id);
        try {
            userDao.saveAndFlush(newData);
            return true;
        } catch(Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public Message deleteUser(Integer id) {
        try {
            userDao.deleteById(id);
            return new Message("user deleted.");
        } catch(Exception e) {
            logger.error(e.getMessage());
            return new Message("user not deleted: "+e.getLocalizedMessage());
        }
    }

    // Métodos auxiliares
    private boolean isAvailableUsername(String username){
        List<User> user = userDao.findByUsername(username);
        if(user.size()==0){
            return true;
        }
        return false;
    }
}
