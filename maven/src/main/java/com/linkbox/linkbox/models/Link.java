package com.linkbox.linkbox.models;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LINK")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int linkId;
    private int userId;
    private String title;
    private String url;
    private int views;
    private String inTheTrash;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private LocalTime duration;

    public Link(int userId, String title, String url, LocalTime duration) {
        this.userId = userId;
        this.title = title;
        this.url = url;
        this.views = 0;
        this.inTheTrash = "N";
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
        this.duration = duration;
    }
}
