package com.prokys.PlayersStats.entity;

import jakarta.persistence.*;

@Entity
public class PlayersMatchesStats {

    // fields

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "players_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "matches_id")
    private Match match;

    @Column(name = "goals")
    private int goals;

    @Column(name = "assists")
    private int assists;

    @Column(name = "total", insertable = false, updatable = false)
    private int total;

    @Column(name = "penalties")
    private int penalties;

    @Column(name = "on_field_difference")
    private int onFieldDifference;

    @Column(name = "shots")
    private int shots;

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public int getOnFieldDifference() {
        return onFieldDifference;
    }

    public void setOnFieldDifference(int onFieldDifference) {
        this.onFieldDifference = onFieldDifference;
    }

    public int getShots() {
        return shots;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    // constructors
    public PlayersMatchesStats() {
    }

    @Override
    public String toString() {
        return "PlayersMatchesStats{" +
                "id=" + id +
                ", player=" + player.getId() +
                ", match=" + match.getId() +
                ", goals=" + goals +
                ", assists=" + assists +
                ", total=" + total +
                ", penalties=" + penalties +
                ", onFieldDifference=" + onFieldDifference +
                ", shots=" + shots +
                '}';
    }
}
