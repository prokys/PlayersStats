package com.prokys.PlayersStats.controller;

import com.prokys.PlayersStats.entity.Season;
import com.prokys.PlayersStats.service.seasons.SeasonsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/seasons")
public class SeasonsController {

    SeasonsService seasonsService;

    public SeasonsController(SeasonsService sService){
        seasonsService = sService;
    }

    @GetMapping
    public String getSeasons(@RequestParam(name = "text", required = false)String text, Model model){

        // create empty list
        List<Season> seasons;

        // get list of seasons
        if (text != null && !text.isEmpty()){
            seasons = seasonsService.findSeasons(text);
        }else {
            seasons = seasonsService.findSeasons();
        }

        // add into model
        model.addAttribute("seasons", seasons);

        return "/seasons/seasons-list";
    }

    @GetMapping("/detail")
    public String seasonDetail(@RequestParam(name = "seasonId")int id, Model model){

        Season season = seasonsService.findSeasonById(id);

        model.addAttribute("season", season);

        return "/seasons/seasons-detail";
    }

    @GetMapping("/edit")
    public String seasonEdit(@RequestParam(name = "seasonId")int id, Model model){

        Season season = seasonsService.findSeasonById(id);

        model.addAttribute("season", season);

        return "/seasons/seasons-detail-edit";
    }

}
