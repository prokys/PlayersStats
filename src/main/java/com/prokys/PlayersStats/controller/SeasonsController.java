package com.prokys.PlayersStats.controller;

import com.prokys.PlayersStats.entity.Season;
import com.prokys.PlayersStats.service.seasons.SeasonsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/seasons")
public class SeasonsController {

    SeasonsService seasonsService;

    public SeasonsController(SeasonsService sService){
        seasonsService = sService;
    }

    @GetMapping
    public String getSeasons(Model model){

        // get list of seasons
        List<Season> seasons = seasonsService.findSeasons();

        // add into model
        model.addAttribute("seasons", seasons);

        return "/seasons/seasons-list";
    }

}
