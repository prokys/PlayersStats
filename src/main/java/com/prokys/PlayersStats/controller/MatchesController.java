package com.prokys.PlayersStats.controller;

import com.prokys.PlayersStats.entity.Match;
import com.prokys.PlayersStats.service.MatchesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/matches")
public class MatchesController {

    MatchesService matchesService;

    MatchesController(MatchesService service){
        matchesService = service;
    }

    @GetMapping
    public String listMatches(@RequestParam(name = "text", required = false) String text, Model model){
        List<Match> matches;

        if (text != null && !text.isEmpty()) {
            matches = matchesService.findMatches(text);
        }else {
            matches= matchesService.findMatches();
        }
        model.addAttribute("matches", matches);

        return "matches-list";
    }

    @GetMapping("/detail")
    public String matchDetail(@RequestParam(name = "matchId") int id, Model model){
        Match match = matchesService.findMatchById(id);

        model.addAttribute("match", match);

        if (match == null){
            return "redirect:/matches";
        }
        return "matches-detail";
    }

    @GetMapping("/addNewMatch")
    public String addNewMatch(Model model){
        Match match = new Match();

        model.addAttribute("match", match);

        return "match-detail-edit";
    }
}
