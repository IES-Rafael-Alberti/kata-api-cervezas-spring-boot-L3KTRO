// Category.java
package com.lestro.kata.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories")
public class Category {
    @Getter
    @Setter
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cat_name", nullable = false)
    private String catName;

    @Column(name = "last_mod", nullable = false)
    private LocalDateTime lastMod;

    // Getters and Setters
}