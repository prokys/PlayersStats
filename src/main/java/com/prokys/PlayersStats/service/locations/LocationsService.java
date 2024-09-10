package com.prokys.PlayersStats.service.locations;

import com.prokys.PlayersStats.entity.Location;

import java.util.List;

public interface LocationsService {

    List<Location> getLocation();

    List<Location> getLocation(String text);

}
