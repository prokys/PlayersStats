package com.prokys.PlayersStats.controller;

import com.prokys.PlayersStats.entity.Player;
import com.prokys.PlayersStats.service.PlayersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayersController {

    private PlayersService playersService;

    public PlayersController (PlayersService service){
        playersService = service;
    }

    @GetMapping("/")
    public String listPlayers(Model model){
        List<Player> players = playersService.findPlayers();

        model.addAttribute("players", players);

        return "players-list";
    }
}
