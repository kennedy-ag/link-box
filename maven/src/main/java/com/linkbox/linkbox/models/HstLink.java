package com.linkbox.linkbox.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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
@Table(name = "HST_LINK")
public class HstLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historyId;
    private int linkId;
    private String operationType;
    private String operationText;
    Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

    public HstLink(int linkId, String operationType, String operationText) {
        this.linkId = linkId;
        this.operationType = operationType;
        this.operationText = operationText;
    }
}
