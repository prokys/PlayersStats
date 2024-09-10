package com.prokys.PlayersStats.dao.locations;

import com.prokys.PlayersStats.entity.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationsDAOImpl implements LocationsDAO{

    EntityManager entityManager;

    public LocationsDAOImpl(EntityManager manager){
        entityManager = manager;
    }

    @Override
    public List<Location> getLocations() {

        TypedQuery<Location> query = entityManager.createQuery("FROM Location", Location.class);

        return query.getResultList();
    }

    @Override
    public List<Location> getLocations(String text){

        TypedQuery<Location> query = entityManager.createQuery("FROM Location WHERE LOWER(name) LIKE LOWER(:text) " +
                "OR LOWER(name) LIKE LOWER(CONCAT('% ', :text))", Location.class);

        query.setParameter("text", text.toLowerCase()+"%");

        return query.getResultList();
    }
}
