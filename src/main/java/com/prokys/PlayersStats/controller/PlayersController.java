package com.prokys.PlayersStats.controller;

import com.prokys.PlayersStats.entity.Player;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayersController {

    @GetMapping("/")
    public String listPlayers(Model model){
        List<Player> players = new ArrayList<>();
        LocalDate date = LocalDate.of(2024,1,2);

        players.add(new Player("ASDAS", "ADSD", "asdads@gmail.com", date));
        players.add(new Player("Test", "Test", "Test@gmail.com", date));


        model.addAttribute("players", players);

        return "players-list";
    }
}
