package com.prokys.PlayersStats.service;

import com.prokys.PlayersStats.dao.SeasonsDAO;
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
}
