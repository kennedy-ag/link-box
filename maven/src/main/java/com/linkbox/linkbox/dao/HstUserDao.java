package com.linkbox.linkbox.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linkbox.linkbox.models.HstUser;

public interface HstUserDao extends JpaRepository<HstUser, Integer> {}
