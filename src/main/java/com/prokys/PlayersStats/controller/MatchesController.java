package com.prokys.PlayersStats.controller;

import com.prokys.PlayersStats.entity.Club;
import com.prokys.PlayersStats.entity.Location;
import com.prokys.PlayersStats.entity.Match;
import com.prokys.PlayersStats.entity.Season;
import com.prokys.PlayersStats.service.clubs.ClubsService;
import com.prokys.PlayersStats.service.locations.LocationsService;
import com.prokys.PlayersStats.service.matches.MatchesService;
import com.prokys.PlayersStats.service.seasons.SeasonsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/matches")
public class MatchesController {

    MatchesService matchesService;
    ClubsService clubsService;
    SeasonsService seasonsService;
    LocationsService locationsService;

    MatchesController(MatchesService service, ClubsService cService, SeasonsService sService, LocationsService lService){
        matchesService = service;
        clubsService = cService;
        seasonsService = sService;
        locationsService = lService;
    }

    @GetMapping
    public String listMatches(@RequestParam(name = "text", required = false) String text, Model model){
        // create empty list for matches
        List<Match> matches;

        // if there is no text parameter, list all matches
        // if there is a text parameter, list matches starting with text
        if (text != null && !text.isEmpty()) {
            matches = matchesService.findMatches(text);
        }else {
            matches= matchesService.findMatches();
        }

        // add into model
        model.addAttribute("matches", matches);

        return "/matches/matches-list";
    }

    @GetMapping("/detail")
    public String matchDetail(@RequestParam(name = "matchId") int id, Model model){

        // get match by id
        Match match = matchesService.findMatchById(id);

        model.addAttribute("match", match);

        if (match == null){
            return "redirect:/matches";
        }
        return "/matches/matches-detail";
    }

    @GetMapping("/addNewMatch")
    public String addNewMatch(Model model){
        // create empty match
        Match match = new Match();

        // get clubs
        List<Club> clubs = clubsService.findClubs();

        // get seasons
        List<Season> seasons = seasonsService.findSeasons();

        // get locations
        List<Location> locations = locationsService.getLocation();

        // add into model
        model.addAttribute("clubs", clubs);
        model.addAttribute("match", match);
        model.addAttribute("seasons", seasons);
        model.addAttribute("locations", locations);

        return "/matches/matches-detail-edit";
    }

    @GetMapping("/edit")
    public String editMatch(@RequestParam(name = "matchId")int id, Model model){

        // get match by parameter id
        Match match = matchesService.findMatchById(id);

        // get clubs
        List<Club> clubs = clubsService.findClubs();

        // get seasons
        List<Season> seasons = seasonsService.findSeasons();

        // get locations
        List<Location> locations = locationsService.getLocation();

        // add into model
        model.addAttribute("clubs", clubs);
        model.addAttribute("match", match);
        model.addAttribute("seasons", seasons);
        model.addAttribute("locations", locations);

        return "/matches/matches-detail-edit";
    }

    @PostMapping("/save")
    public String saveMatch(@ModelAttribute(name = "match") Match match){

        // save Match passed as attribute
        matchesService.saveMatch(match);

        return "redirect:/matches/detail?matchId="+match.getId();
    }

    @GetMapping("/delete")
    public String deleteMatch(@RequestParam(name = "matchId") int id){

        // delete match with parameter id
        matchesService.deleteMatch(id);

        return "redirect:/matches";
    }
}
