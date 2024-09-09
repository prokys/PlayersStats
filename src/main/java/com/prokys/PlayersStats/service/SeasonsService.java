package com.prokys.PlayersStats.service;

import com.prokys.PlayersStats.entity.Season;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SeasonsService {

    List<Season> findSeasons();
}
