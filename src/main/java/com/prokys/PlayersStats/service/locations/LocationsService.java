package com.prokys.PlayersStats.service.locations;

import com.prokys.PlayersStats.entity.Location;

import java.util.List;

public interface LocationsService {

    List<Location> getLocation();

    List<Location> getLocation(String text);

    Location findLocationById(int id);

    void saveLocation(Location location);

    void deleteLocationById(int id);

}
