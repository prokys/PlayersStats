package com.prokys.PlayersStats.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

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

    @Column(name = "home_team")
    private String homeTeam;

    @Column(name = "opponent")
    private String opponent;

    @Column(name = "location")
    private String location;

    @Column(name = "season")
    private String season;

    @OneToMany(mappedBy = "match")
    List<PlayersMatchesStats> playersMatchesStats;

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

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
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

    public List<PlayersMatchesStats> getPlayersMatchesStats() {
        return playersMatchesStats;
    }

    public void setPlayersMatchesStats(List<PlayersMatchesStats> playersMatchesStats) {
        this.playersMatchesStats = playersMatchesStats;
    }

    // constructors

    public Match() {
    }

    public Match(LocalDate matchDate, String homeTeam, String opponent, String location, String season) {
        this.matchDate = matchDate;
        this.homeTeam = homeTeam;
        this.opponent = opponent;
        this.location = location;
        this.season = season;
    }
}
