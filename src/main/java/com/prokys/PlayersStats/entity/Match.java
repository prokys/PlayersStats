package com.prokys.PlayersStats.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "match_date")
    private LocalDate matchDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_team_id")
    private Club homeTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opponent_id")
    private Club opponent;

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

    public Club getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Club homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Club getOpponent() {
        return opponent;
    }

    public void setOpponent(Club opponent) {
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

    public Match(LocalDate matchDate, Club homeTeam, Club opponent, String location, String season) {
        this.matchDate = matchDate;
        this.homeTeam = homeTeam;
        this.opponent = opponent;
        this.location = location;
        this.season = season;
    }
}
