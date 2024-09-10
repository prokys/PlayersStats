package com.prokys.PlayersStats.dao.locations;

import com.prokys.PlayersStats.entity.Location;

import java.util.List;

public interface LocationsDAO {

    List<Location> getLocations();

    List<Location> getLocations(String text);

    Location getLocationById(int id);

    void saveLocation(Location location);
}
