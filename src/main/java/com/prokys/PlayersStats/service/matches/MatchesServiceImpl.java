package com.prokys.PlayersStats.service.matches;

import com.prokys.PlayersStats.dao.matches.MatchesDao;
import com.prokys.PlayersStats.entity.Match;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public List<Match> findMatches(String text) {
        return matchesDao.findMatches(text);
    }
    @Override
    public Match findMatchById(int id){
        return matchesDao.findMatchById(id);
    }

    @Transactional
    @Override
    public void saveMatch(Match match) {
        matchesDao.saveMatch(match);
    }

    @Transactional
    @Override
    public void deleteMatch(int id) {
        matchesDao.deleteMatch(id);
    }
}
