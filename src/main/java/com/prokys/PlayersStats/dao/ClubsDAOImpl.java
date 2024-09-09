package com.prokys.PlayersStats.dao;

import com.prokys.PlayersStats.entity.Club;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClubsDAOImpl implements ClubsDAO{

    private EntityManager entityManager;

    public ClubsDAOImpl(EntityManager manager){
     entityManager = manager;
    }

    @Override
    public List<Club> findClubs() {

        TypedQuery<Club> query = entityManager.createQuery("FROM Club", Club.class);

        return query.getResultList();
    }
}
