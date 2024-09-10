package com.prokys.PlayersStats.controller;

import com.prokys.PlayersStats.entity.Location;
import com.prokys.PlayersStats.service.locations.LocationsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/locations")
public class LocationsController {

    private LocationsService locationsService;

    public LocationsController(LocationsService lService){
        locationsService = lService;
    }

    @GetMapping
    public String getLocations(@RequestParam(name = "text", required = false)String text, Model model){

        List<Location> locations;

        if (text != null && !text.isEmpty()){
            locations = locationsService.getLocation(text);
        } else {
            locations = locationsService.getLocation();
        }

        model.addAttribute("location", locations);

        return "/locations/locations-list";
    }

    @GetMapping("/detail")
    public String locationDetail(@RequestParam(name = "locationId")int id, Model model){

        Location location = locationsService.findLocationById(id);

        model.addAttribute("location", location);

        return "/locations/locations-detail";
    }

    @GetMapping("/edit")
    public String editLocation(@RequestParam(name = "locationId") int id, Model model){

        Location location = locationsService.findLocationById(id);

        model.addAttribute("location", location);

        return "/locations/locations-detail-edit";
    }

    @PostMapping("/save")
    public String saveLocation(@ModelAttribute(name = "location") Location location, Model model){

        locationsService.saveLocation(location);

        return "redirect:/locations/detail?locationId=" + location.getId();
    }

}
