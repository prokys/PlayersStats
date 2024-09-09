package com.prokys.PlayersStats.dao;

import com.prokys.PlayersStats.entity.Season;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SeasonsDAOImpl implements SeasonsDAO {

    EntityManager entityManager;

    public SeasonsDAOImpl(EntityManager manager){
        entityManager = manager;
    }

    @Override
    public List<Season> findSeasons() {
        TypedQuery<Season> query = entityManager.createQuery("FROM Season", Season.class);

        return query.getResultList();
    }
}
