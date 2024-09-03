package com.prokys.PlayersStats.dao;

import com.prokys.PlayersStats.entity.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayersDAOImpl implements PlayersDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public PlayersDAOImpl(EntityManager manager){
        entityManager = manager;
    }

    @Override
    public List<Player> findPlayers() {

        // create query
        TypedQuery<Player> query = entityManager.createQuery("FROM Player", Player.class);

        // execute query
        List<Player> players = query.getResultList();

        return players;
    }
}
