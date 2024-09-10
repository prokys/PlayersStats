package com.prokys.PlayersStats.service.locations;

import com.prokys.PlayersStats.dao.locations.LocationsDAO;
import com.prokys.PlayersStats.entity.Location;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocationsServiceImpl implements LocationsService{

    LocationsDAO locationsDAO;

    public LocationsServiceImpl(LocationsDAO dao){
        locationsDAO = dao;
    }

    @Override
    public List<Location> getLocation() {
        return locationsDAO.getLocations();
    }

    @Override
    public List<Location> getLocation(String text) {
        return locationsDAO.getLocations(text);
    }

    @Override
    public Location findLocationById(int id) {
        return locationsDAO.getLocationById(id);
    }

    @Override
    @Transactional
    public void saveLocation(Location location) {
        locationsDAO.saveLocation(location);
    }
}
