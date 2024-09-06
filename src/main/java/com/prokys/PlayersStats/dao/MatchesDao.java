package com.prokys.PlayersStats.dao;

import com.prokys.PlayersStats.entity.Match;

import java.util.List;

public interface MatchesDao {

    List<Match> findMatches();

    List<Match> findMatches(String text);

    Match findMatchById(int id);

    void saveMatch(Match match);

}
