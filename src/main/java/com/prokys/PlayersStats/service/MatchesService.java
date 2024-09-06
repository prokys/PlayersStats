package com.prokys.PlayersStats.service;

import com.prokys.PlayersStats.entity.Match;

import java.util.List;

public interface MatchesService {

    public List<Match> findMatches();

    public List<Match> findMatches(String text);

}
