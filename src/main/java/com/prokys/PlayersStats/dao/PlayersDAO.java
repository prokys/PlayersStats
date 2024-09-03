package com.prokys.PlayersStats.dao;

import com.prokys.PlayersStats.entity.Player;

import java.util.List;

public interface PlayersDAO {

    List<Player> findPlayers();

    Player findPlayerById(int playerId);
}
