package com.prokys.PlayersStats.dao.playersMatchesStats;

import com.prokys.PlayersStats.entity.PlayersMatchesStats;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class PlayersMatchesStatsDAOImpl implements PlayersMatchesStatsDAO{

    private EntityManager entityManager;

    public PlayersMatchesStatsDAOImpl(EntityManager manager){
        entityManager = manager;
    }

    @Override
    public void saveStat(PlayersMatchesStats playersMatchesStats) {
        entityManager.merge(playersMatchesStats);
    }
}
