package com.linkbox.linkbox.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linkbox.linkbox.models.Link;

public interface LinkDao extends JpaRepository<Link, Integer> {}
