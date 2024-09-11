package com.prokys.PlayersStats.service.seasons;

import com.prokys.PlayersStats.dao.seasons.SeasonsDAO;
import com.prokys.PlayersStats.entity.Season;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class SeasonsServiceImpl implements SeasonsService{

    SeasonsDAO seasonsDAO;

    public SeasonsServiceImpl(SeasonsDAO dao){
        seasonsDAO = dao;
    }

    @Override
    public List<Season> findSeasons() {
        return seasonsDAO.findSeasons();
    }

    @Override
    public List<Season> findSeasons(String text) {
        return seasonsDAO.findSeasons(text);
    }

    @Override
    public Season findSeasonById(int id) {
        return seasonsDAO.findSeasonById(id);
    }

    @Override
    @Transactional
    public void saveSeason(Season season) {
        seasonsDAO.saveSeason(season);
    }
}
