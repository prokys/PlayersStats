package com.prokys.PlayersStats.controller;

import com.prokys.PlayersStats.entity.Player;
import com.prokys.PlayersStats.service.PlayersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayersController {

    private PlayersService playersService;

    public PlayersController(PlayersService service) {
        playersService = service;
    }

    @GetMapping()
    public String listPlayers(@RequestParam(name = "name", required = false) String name, Model model) {
        List<Player> players;

        if (name != null && !name.isEmpty()) {
            // get list of players from database
            players = playersService.findPlayers(name);
        } else {
            // get list of players starting with "name" parameter from database
            players = playersService.findPlayers();
        }

        // add them to model
        model.addAttribute("players", players);

        System.out.println(players.get(0).getDateOfBirth());

        return "players-list";
    }

    @GetMapping("/profile")
    public String getPlayersProfile(@RequestParam("playerId") int playerId, Model model) {
        // find player by id
        Player player = playersService.findPlayerById(playerId);

        // add them to model
        model.addAttribute("player", player);

        return "players-profile";
    }

    @GetMapping("/edit")
    public String getPlayersProfileEdit(@RequestParam("playerId") int playerId, Model model) {

        // find player by id
        Player player = playersService.findPlayerById(playerId);

        // add them to model
        model.addAttribute("player", player);

        return "players-profile-edit";
    }

    @PostMapping("/update")
    public String updatePlayer(@ModelAttribute("player") Player player){

        // update player
        playersService.updatePlayer(player);

        return "redirect:/players";
    }
}
