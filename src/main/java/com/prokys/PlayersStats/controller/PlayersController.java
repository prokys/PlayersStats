package com.prokys.PlayersStats.controller;

import com.prokys.PlayersStats.entity.Player;
import com.prokys.PlayersStats.service.PlayersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayersController {

    private PlayersService playersService;

    public PlayersController (PlayersService service){
        playersService = service;
    }

    @GetMapping()
    public String listPlayers(Model model){

        // get list of players from database
        List<Player> players = playersService.findPlayers();

        // add them to model
        model.addAttribute("players", players);

        return "players-list";
    }

    @GetMapping("/profile")
    public String getPlayersProfile(@RequestParam("playerId") int playerId, Model model){

        // find player by id
        Player player = playersService.findPlayerById(playerId);

        // add them to model
        model.addAttribute("player", player);

        return "players-profile";
    }
    @GetMapping("/edit")
    public String getPlayersProfileEdit(@RequestParam("playerId") int playerId, Model model){

        // find player by id
        Player player = playersService.findPlayerById(playerId);

        // add them to model
        model.addAttribute("player", player);

        return "players-profile-edit";
    }

    @GetMapping("/getPlayers")
    private String getPlayers(@RequestParam("name") String name, Model model){
        List<Player> players = new ArrayList<>();

        if (name.equals("")){
            players = playersService.findPlayers();
            model.addAttribute("players", players);
        } else {
            players = playersService.findPlayers(name);
            model.addAttribute("players", players);
        }
        return "players-list";
    }
}
