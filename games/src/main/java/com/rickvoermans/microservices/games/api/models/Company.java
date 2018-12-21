package com.rickvoermans.microservices.games.api.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "companies")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "founded")
    private LocalDate founded;

    @Column(name = "developed")
    private ArrayList<String> developed;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFounded() {
        return founded;
    }

    public void setFounded(LocalDate founded) {
        this.founded = founded;
    }

    public ArrayList<String> getDeveloped() {
        return developed;
    }

    public void setDeveloped(ArrayList<String> developed) {
        this.developed = developed;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
