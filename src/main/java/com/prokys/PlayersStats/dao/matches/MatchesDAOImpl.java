package com.prokys.PlayersStats.dao.matches;

import com.prokys.PlayersStats.entity.Match;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MatchesDAOImpl implements MatchesDao{

    // define field for entity manager
    private EntityManager entityManager;

    //

    public MatchesDAOImpl(EntityManager manager){
        entityManager = manager;
    }

    @Override
    public List<Match> findMatches() {

        TypedQuery<Match> query = entityManager.createQuery("FROM Match", Match.class);

        return query.getResultList();
    }

    @Override
    public List<Match> findMatches(String text) {

        // create query
        TypedQuery<Match> query = entityManager.createQuery(
                "FROM Match m JOIN m.homeTeam ht JOIN m.opponent o " +
                   "WHERE LOWER(ht.name) LIKE LOWER(:text) OR LOWER(ht.name) LIKE LOWER(CONCAT('% ', :text)) "+
                        "OR LOWER(o.name) LIKE LOWER(:text) OR LOWER(o.name) LIKE LOWER(CONCAT('% ', :text))", Match.class);

        // add parameter
        query.setParameter("text", text.toLowerCase()+"%");

        // execute query
        List<Match> matches = query.getResultList();

        return matches;
    }

    @Override
    public Match findMatchById(int id) {
        return entityManager.find(Match.class, id);
    }

    @Override
    public void saveMatch(Match match) {
        entityManager.merge(match);
    }

    @Override
    public void deleteMatch(int id) {

        Match match = entityManager.find(Match.class, id);

        entityManager.remove(match);
    }
}
