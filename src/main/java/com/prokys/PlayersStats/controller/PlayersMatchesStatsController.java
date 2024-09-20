package com.prokys.PlayersStats.controller;

import com.prokys.PlayersStats.entity.Match;
import com.prokys.PlayersStats.entity.Player;
import com.prokys.PlayersStats.entity.PlayersMatchesStats;
import com.prokys.PlayersStats.service.matches.MatchesService;
import com.prokys.PlayersStats.service.players.PlayersService;
import com.prokys.PlayersStats.service.playersMatchesStats.PlayersMatchesStatsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/stats")
public class PlayersMatchesStatsController {

    private PlayersService playersService;
    private MatchesService matchesService;
    private PlayersMatchesStatsService playersMatchesStatsService;

    public PlayersMatchesStatsController(PlayersService pService, MatchesService mService, PlayersMatchesStatsService pmsService){
        playersService = pService;
        matchesService = mService;
        playersMatchesStatsService = pmsService;
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
            players.removeAll(playersMatchesStatsService.getPlayerByMatchId(matchId));
        }

        if (matchId != null){
            Match match = matchesService.findMatchById(matchId);
            matches.add(match);
        } else {
            matches = matchesService.findMatches();
            matches.removeAll(playersMatchesStatsService.getMatchesByPlayerId(playerId));
        }

        model.addAttribute("players", players);
        model.addAttribute("matches", matches);
        model.addAttribute("stat", playersMatchesStats);

        return "/stats/stats-edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute(name = "stat") PlayersMatchesStats playersMatchesStats){

        playersMatchesStatsService.saveStat(playersMatchesStats);

        return "redirect:/players";
    }
}
