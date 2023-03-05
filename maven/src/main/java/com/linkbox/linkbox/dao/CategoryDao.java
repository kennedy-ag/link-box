package com.linkbox.linkbox.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.linkbox.linkbox.models.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {
    @Query(value = "select * from category where name = :name", nativeQuery = true)
    List<Category> findByName(@Param("name") String name);
}
