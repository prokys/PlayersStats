package com.prokys.PlayersStats.service;

import com.prokys.PlayersStats.dao.LocationsDAO;
import com.prokys.PlayersStats.entity.Location;

import java.util.List;

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
