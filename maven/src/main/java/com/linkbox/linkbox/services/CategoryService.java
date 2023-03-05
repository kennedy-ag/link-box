package com.linkbox.linkbox.services;

import com.linkbox.linkbox.models.Message;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkbox.linkbox.dao.CategoryDao;
import com.linkbox.linkbox.models.Category;

@Service
public class CategoryService {
    Logger logger = Logger.getLogger("Category logger");
    
    @Autowired
    CategoryDao categoryDao;

    public Message newCategory(Category category) {
        category.setName(category.getName().toLowerCase());
        if(categoryAlreadyExists(category.getName())){
            return new Message("category not added: already exists");
        } else {
            categoryDao.save(category);
            return new Message("category added");
        }
    }

    private boolean categoryAlreadyExists(String name){
        List<Category> categoriesByName = categoryDao.findByName(name.toLowerCase());
        if(categoriesByName.size()>0){
            return true;
        }
        return false;
    }

}
