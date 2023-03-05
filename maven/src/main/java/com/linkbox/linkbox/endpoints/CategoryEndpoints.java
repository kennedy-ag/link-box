package com.linkbox.linkbox.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.linkbox.linkbox.models.Message;
import com.linkbox.linkbox.models.Category;
import com.linkbox.linkbox.services.CategoryService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class CategoryEndpoints {

    @Autowired
    CategoryService categoryService;
    
    @Operation(summary = "Create a new category")
    @RequestMapping(path = "/categories/", method = RequestMethod.POST)
    public ResponseEntity<Message> newCategory(@RequestBody Category category){
        Message msg = categoryService.newCategory(category);
        return new ResponseEntity<Message>(msg, HttpStatus.CREATED);
    }
}
