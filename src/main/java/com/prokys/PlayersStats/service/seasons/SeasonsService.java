package com.prokys.PlayersStats.service.seasons;

import com.prokys.PlayersStats.entity.Season;

import java.util.List;


public interface SeasonsService {

    List<Season> findSeasons();

    List<Season> findSeasons(String text);

    Season findSeasonById(int id);

    void saveSeason(Season season);
}
