package com.linkbox.linkbox.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "HST_USER")
public class HstUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historyId;
    private int userId;
    private String operationType;
    private String operationText;
    Timestamp timestamp;

    public HstUser(int userId, String operationType, String operationText) {
        this.userId = userId;
        this.operationType = operationType;
        this.operationText = operationText;
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
    }
}
