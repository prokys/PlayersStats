package com.prokys.PlayersStats.controller;

import com.prokys.PlayersStats.entity.Match;
import com.prokys.PlayersStats.service.MatchesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/matches")
public class MatchesController {

    MatchesService matchesService;

    MatchesController(MatchesService service){
        matchesService = service;
    }

    @GetMapping
    public String listMatches(Model model){
        List<Match> matches = matchesService.findMatches();

        model.addAttribute("matches", matches);

        return "matches-list";
    }
}
