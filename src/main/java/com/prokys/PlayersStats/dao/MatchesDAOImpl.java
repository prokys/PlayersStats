package com.prokys.PlayersStats.dao;

import com.prokys.PlayersStats.entity.Match;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MatchesDAOImpl implements MatchesDao{

    // define field for entity manager
    private EntityManager entityManager;

    //

    public MatchesDAOImpl(EntityManager manager){
        entityManager = manager;
    }

    @Override
    public List<Match> findMatches() {

        TypedQuery<Match> query = entityManager.createQuery("FROM Match", Match.class);

        return query.getResultList();
    }
}
