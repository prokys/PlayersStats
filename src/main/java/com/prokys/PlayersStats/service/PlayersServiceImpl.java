package com.prokys.PlayersStats.service;

import com.prokys.PlayersStats.dao.PlayersDAO;
import com.prokys.PlayersStats.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersServiceImpl implements PlayersService{

    private PlayersDAO playersDAO;

    public PlayersServiceImpl(PlayersDAO dao){
        playersDAO = dao;
    }

    @Override
    public List<Player> findPlayers() {
        return playersDAO.findPlayers();
    }
}
