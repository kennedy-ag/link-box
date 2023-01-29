package com.linkbox.linkbox.endpoints;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorEndpoints {
    
    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public ResponseEntity<String> error(){
        return new ResponseEntity<String>("404 - Not Found", HttpStatus.NOT_FOUND);
    }
}