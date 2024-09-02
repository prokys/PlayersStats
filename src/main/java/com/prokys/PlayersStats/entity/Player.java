package com.prokys.PlayersStats.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "players")
public class Player {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

}
