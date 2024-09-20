package com.prokys.PlayersStats.service.playersMatchesStats;

import com.prokys.PlayersStats.entity.Match;
import com.prokys.PlayersStats.entity.Player;
import com.prokys.PlayersStats.entity.PlayersMatchesStats;

import java.util.List;

public interface PlayersMatchesStatsService {

    public void saveStat(PlayersMatchesStats playersMatchesStats);

    public List<Match> getMatchesByPlayerId(int id);

    public List<Player> getPlayerByMatchId(int id);

}
