package com.prokys.PlayersStats.service.matches;

import com.prokys.PlayersStats.entity.Match;

import java.util.List;

public interface MatchesService {

    public List<Match> findMatches();

    public List<Match> findMatches(String text);

    Match findMatchById(int id);

    void saveMatch(Match match);

    void deleteMatch(int id);

}
