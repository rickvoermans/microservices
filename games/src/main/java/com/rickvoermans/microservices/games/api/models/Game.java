package com.rickvoermans.microservices.games.api.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "genres")
    private List<String> genres;

    @Column(name = "minimum_age")
    private int minimumAge;

    @Column(name = "rating")
    private int rating;

    @Column(name = "company")
    private Company company;


    private int price;

}
