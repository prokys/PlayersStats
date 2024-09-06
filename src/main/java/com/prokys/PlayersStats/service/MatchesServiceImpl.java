package com.prokys.PlayersStats.service;

import com.prokys.PlayersStats.dao.MatchesDao;
import com.prokys.PlayersStats.entity.Match;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchesServiceImpl implements MatchesService{

    MatchesDao matchesDao;

    public MatchesServiceImpl(MatchesDao dao){
        matchesDao = dao;
    }

    @Override
    public List<Match> findMatches() {
        return matchesDao.findMatches();
    }
}
