package com.prokys.PlayersStats.service.clubs;

import com.prokys.PlayersStats.entity.Club;

import java.util.List;

public interface ClubsService {

    List<Club> findClubs();

    List<Club> findClubs(String text);

    Club findClubById(int id);

    void saveClub(Club club);

    void deleteClubById(int id);
}
