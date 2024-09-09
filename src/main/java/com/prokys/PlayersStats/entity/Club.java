package com.prokys.PlayersStats.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clubs")
public class Club {

    // fields and annotations

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "shortcut")
    private String shortcut;

    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY)
    private List<Player> players;

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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    // constructors


    public Club() {
    }

    public Club(String name) {
        this.name = name;
    }
}
