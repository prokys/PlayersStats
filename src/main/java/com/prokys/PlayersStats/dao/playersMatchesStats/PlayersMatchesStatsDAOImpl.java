package com.prokys.PlayersStats.dao.playersMatchesStats;

import com.prokys.PlayersStats.entity.Match;
import com.prokys.PlayersStats.entity.Player;
import com.prokys.PlayersStats.entity.PlayersMatchesStats;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Match> getMatchesByPlayerId(int id) {

        TypedQuery<Match> query = entityManager.createQuery("SELECT pms.match FROM PlayersMatchesStats pms WHERE pms.player.id = :id", Match.class);

        query.setParameter("id", id);

        List<Match> matches = query.getResultList();

        return matches;
    }

    @Override
    public List<Player> getPlayerByMatchId(int id) {

        TypedQuery<Player> query = entityManager.createQuery("SELECT pms.player FROM PlayersMatchesStats pms WHERE pms.match.id = :id", Player.class);

        query.setParameter("id", id);

        List<Player> players = query.getResultList();

        return players;
    }
}
