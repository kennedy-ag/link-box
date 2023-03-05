package com.linkbox.linkbox.models;

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
@Table(name = "LINK_CATEGORY")
public class LinkCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int linkCategoryId;
    private int categoryId;
    private int linkId;
}
