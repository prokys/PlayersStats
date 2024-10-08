package com.prokys.PlayersStats.service.clubs;

import com.prokys.PlayersStats.dao.clubs.ClubsDAO;
import com.prokys.PlayersStats.entity.Club;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClubsServiceImpl implements ClubsService{

    ClubsDAO clubsDAO;

    public ClubsServiceImpl(ClubsDAO dao){
        clubsDAO = dao;
    }

    @Override
    public List<Club> findClubs() {
        return clubsDAO.findClubs();
    }

    @Override
    public List<Club> findClubs(String text) {
        return clubsDAO.findClubs(text);
    }

    @Override
    public Club findClubById(int id) {
        return clubsDAO.findClubById(id);
    }

    @Transactional
    @Override
    public void saveClub(Club club){
        clubsDAO.saveClub(club);
    }
    @Transactional
    @Override
    public void deleteClubById(int id) {
        clubsDAO.deleteClubById(id);
    }
}
