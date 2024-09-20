package com.prokys.PlayersStats.service.playersMatchesStats;


import com.prokys.PlayersStats.dao.playersMatchesStats.PlayersMatchesStatsDAO;
import com.prokys.PlayersStats.entity.Match;
import com.prokys.PlayersStats.entity.Player;
import com.prokys.PlayersStats.entity.PlayersMatchesStats;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayersMatchesStatsServiceImpl implements PlayersMatchesStatsService {

    private PlayersMatchesStatsDAO playersMatchesStatsDAO;

    public PlayersMatchesStatsServiceImpl(PlayersMatchesStatsDAO dao){
        playersMatchesStatsDAO = dao;
    }

    @Override
    @Transactional
    public void saveStat(PlayersMatchesStats playersMatchesStats) {
        playersMatchesStatsDAO.saveStat(playersMatchesStats);
    }

    @Override
    public List<Match> getMatchesByPlayerId(int id) {
        return playersMatchesStatsDAO.getMatchesByPlayerId(id);
    }

    @Override
    public List<Player> getPlayerByMatchId(int id) {
        return playersMatchesStatsDAO.getPlayerByMatchId(id);
    }
}
