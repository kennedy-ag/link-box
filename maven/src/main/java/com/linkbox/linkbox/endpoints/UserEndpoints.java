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

import com.linkbox.linkbox.models.User;
import com.linkbox.linkbox.services.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class UserEndpoints {

    @Autowired
    UserService userService;
    
    @Operation(summary = "Lists all users")
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @Operation(summary = "Create an user")
    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody User user){
        boolean creationSuccess = userService.createUser(user);
        if(creationSuccess){
            return new ResponseEntity<String>("User created.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("User not created.", HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Update an user")
    @RequestMapping(path = "/users", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@RequestBody User user){
        boolean updateSuccess = userService.updateUser(user);
        if(updateSuccess){
            return new ResponseEntity<String>("User updated.", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("User not updated.", HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Delete an user")
    @RequestMapping(path = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        boolean updateSuccess = userService.deleteUser(id);
        if(updateSuccess){
            return new ResponseEntity<String>("User deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("User not deleted.", HttpStatus.BAD_REQUEST);
        }
    }
}