package com.prokys.PlayersStats.service;

import com.prokys.PlayersStats.dao.ClubsDAO;
import com.prokys.PlayersStats.entity.Club;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubsServiceImpl implements ClubsService{

    ClubsDAO clubsDAO;

    public ClubsServiceImpl(ClubsDAO dao){
        clubsDAO = dao;
    }

    @Override
    public List<Club> findClubs() {
        return clubsDAO.findClubs();
    }
}
