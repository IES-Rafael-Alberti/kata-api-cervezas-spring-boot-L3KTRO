package com.lestro.kata.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "beers")
public class Beer {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brewery_id", nullable = false)
    private Integer breweryId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cat_id", nullable = false)
    private Integer catId;

    @Column(name = "style_id", nullable = false)
    private Integer styleId;

    @Column(name = "abv", nullable = false)
    private Float abv;

    @Column(name = "ibu", nullable = false)
    private Float ibu;

    @Column(name = "srm", nullable = false)
    private Float srm;

    @Column(name = "upc", nullable = false)
    private Integer upc;

    @Column(name = "filepath")
    private String filepath;

    @Column(name = "descript")
    private String descript;

    @Column(name = "add_user", nullable = false)
    private Integer addUser;

    @Column(name = "last_mod", nullable = false)
    private LocalDateTime lastMod;

}