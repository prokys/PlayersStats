package com.prokys.PlayersStats.dao.seasons;

import com.prokys.PlayersStats.entity.Season;

import java.util.List;

public interface SeasonsDAO {

    List<Season> findSeasons();

    List<Season> findSeasons(String text);

    Season findSeasonById(int id);

    void saveSeason(Season season);
}
