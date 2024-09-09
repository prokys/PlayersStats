package com.prokys.PlayersStats.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seasons")
public class Season {

    // fields and annotations
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // constructors

    public Season() {
    }

    public Season(String name) {
        this.name = name;
    }
}
