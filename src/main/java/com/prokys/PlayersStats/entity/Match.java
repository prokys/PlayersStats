package com.prokys.PlayersStats.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "matches")
public class Match {

    // fields

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "match_date")
    private LocalDate matchDate;

    @Column(name = "opponent")
    private String opponent;

    @Column(name = "location")
    private String location;

    @Column(name = "season")
    private String season;

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    // constructors

    public Match() {
    }

    public Match(LocalDate matchDate, String opponent, String location, String season) {
        this.matchDate = matchDate;
        this.opponent = opponent;
        this.location = location;
        this.season = season;
    }
}
