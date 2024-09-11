package com.prokys.PlayersStats.service.seasons;

import com.prokys.PlayersStats.dao.seasons.SeasonsDAO;
import com.prokys.PlayersStats.entity.Season;
import org.springframework.stereotype.Service;

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
}
