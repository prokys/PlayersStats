package com.prokys.PlayersStats.dao.players;

import com.prokys.PlayersStats.entity.Player;

import java.util.List;

public interface PlayersDAO {

    List<Player> findPlayers();

    List<Player> findPlayers(String name);

    Player findPlayerById(int playerId);

    void updatePlayer(Player player);

    void deleteById(int id);
}
