package com.linkbox.linkbox.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HST_CATEGORY")
public class HstCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historyId;
    private int categoryId;
    private String operationType;
    private String operationText;
    Timestamp timestamp;
}
