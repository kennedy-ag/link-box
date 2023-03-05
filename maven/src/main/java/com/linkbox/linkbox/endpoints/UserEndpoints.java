package com.linkbox.linkbox.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.linkbox.linkbox.models.HstUser;
import com.linkbox.linkbox.models.Message;
import com.linkbox.linkbox.models.User;
import com.linkbox.linkbox.services.HistoryService;
import com.linkbox.linkbox.services.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class UserEndpoints {

    @Autowired
    UserService userService;

    @Autowired
    HistoryService historyService;
    
    @Operation(summary = "Create an user")
    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public ResponseEntity<Message> createUser(@RequestBody User user){
        Message msg = userService.createUser(user);
        HstUser hstUser = new HstUser(user.getUserId(), "I", "Usuário criado");
        historyService.history(hstUser);
        return new ResponseEntity<Message>(msg, HttpStatus.CREATED);
    }

    @Operation(summary = "Delete an user")
    @RequestMapping(path = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Message> deleteUser(@PathVariable Integer id){
        Message msg = userService.deleteUser(id);
        HstUser hstUser = new HstUser(id, "E", "Usuário excluído");
        historyService.history(hstUser);
        return new ResponseEntity<Message>(msg, HttpStatus.OK);
    }
    
    @Operation(summary = "Lists all users")
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    
    @Operation(summary = "Get user by id")
    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable Integer id){
        return userService.getUser(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update an user")
    @RequestMapping(path = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Message> updateUsername(@PathVariable Integer id, @RequestBody User newData){
        boolean updateSuccess = userService.updateUser(id, newData);
        if(updateSuccess){
            return new ResponseEntity<Message>(new Message("user updated"), HttpStatus.OK);
        } else {
            return new ResponseEntity<Message>(new Message("user not updated"), HttpStatus.BAD_REQUEST);
        }
    }
}