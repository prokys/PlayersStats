package com.prokys.PlayersStats.dao;

import com.prokys.PlayersStats.entity.Season;

import java.util.List;

public interface SeasonsDAO {

    List<Season> findSeasons();
}
