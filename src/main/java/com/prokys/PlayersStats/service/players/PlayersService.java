package com.prokys.PlayersStats.service.players;

import com.prokys.PlayersStats.entity.Player;

import java.util.List;

public interface PlayersService {

    List<Player> findPlayers();

    List<Player> findPlayers(String name);

    Player findPlayerById(int playerId);

    void updatePlayer(Player player);

    void deletePlayer(int id);
}
