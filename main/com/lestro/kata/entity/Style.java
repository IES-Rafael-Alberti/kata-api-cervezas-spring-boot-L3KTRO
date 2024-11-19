package com.lestro.kata.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "styles")
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cat_id", nullable = false)
    private Integer catId;

    @Column(name = "style_name", nullable = false)
    private String styleName;

    @Column(name = "last_mod", nullable = false)
    private LocalDateTime lastMod;
}