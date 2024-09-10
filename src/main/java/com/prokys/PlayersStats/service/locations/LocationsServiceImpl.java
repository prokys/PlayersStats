package com.prokys.PlayersStats.service.locations;

import com.prokys.PlayersStats.dao.locations.LocationsDAO;
import com.prokys.PlayersStats.entity.Location;
import org.springframework.stereotype.Service;

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
}
