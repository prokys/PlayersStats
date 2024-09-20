package com.prokys.PlayersStats.service.playersMatchesStats;


import com.prokys.PlayersStats.dao.playersMatchesStats.PlayersMatchesStatsDAO;
import com.prokys.PlayersStats.entity.PlayersMatchesStats;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
