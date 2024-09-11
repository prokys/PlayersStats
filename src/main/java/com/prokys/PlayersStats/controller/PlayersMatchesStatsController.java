package com.prokys.PlayersStats.controller;

import com.prokys.PlayersStats.entity.Match;
import com.prokys.PlayersStats.entity.Player;
import com.prokys.PlayersStats.entity.PlayersMatchesStats;
import com.prokys.PlayersStats.service.matches.MatchesService;
import com.prokys.PlayersStats.service.players.PlayersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/stats")
public class PlayersMatchesStatsController {

    private PlayersService playersService;
    private MatchesService matchesService;

    public PlayersMatchesStatsController(PlayersService pService, MatchesService mService){
        playersService = pService;
        matchesService = mService;
    }

    @GetMapping("/add")
    public String addStat(@RequestParam(name = "playerId", required = false)Integer playerId, @RequestParam(name = "matchId", required = false) Integer matchId, Model model){

        List<Player> players = new ArrayList<>();
        List<Match> matches = new ArrayList<>();
        PlayersMatchesStats playersMatchesStats = new PlayersMatchesStats();


        if (playerId != null){
            Player player = playersService.findPlayerById(playerId);
            players.add(player);
        } else {
            players = playersService.findPlayers();
        }

        if (matchId != null){
            Match match = matchesService.findMatchById(matchId);
            matches.add(match);
        } else {
            matches = matchesService.findMatches();
        }

        model.addAttribute("players", players);
        model.addAttribute("matches", matches);
        model.addAttribute("stat", playersMatchesStats);

        return "/stats/stats-edit";
    }

}
