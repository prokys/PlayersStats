package com.prokys.PlayersStats.service;

import com.prokys.PlayersStats.dao.PlayersDAO;
import com.prokys.PlayersStats.entity.Player;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public List<Player> findPlayers(String name) {
        return playersDAO.findPlayers(name);
    }

    @Override
    public Player findPlayerById(int playerId) {
        return playersDAO.findPlayerById(playerId);
    }

    @Override
    @Transactional
    public void updatePlayer(Player player) {
        playersDAO.updatePlayer(player);
    }

    @Override
    @Transactional
    public void deletePlayer(int id) {
        playersDAO.deleteById(id);
    }


}
