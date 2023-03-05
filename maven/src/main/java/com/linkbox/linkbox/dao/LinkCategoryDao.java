package com.linkbox.linkbox.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linkbox.linkbox.models.LinkCategory;

public interface LinkCategoryDao extends JpaRepository<LinkCategory, Integer> {}
