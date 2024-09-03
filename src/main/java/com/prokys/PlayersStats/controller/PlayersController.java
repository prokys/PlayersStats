package com.prokys.PlayersStats.controller;

import com.prokys.PlayersStats.dao.PlayersDAO;
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

    private PlayersDAO playersDAO;

    public PlayersController (PlayersDAO dao){
        playersDAO = dao;
    }

    @GetMapping("/")
    public String listPlayers(Model model){
        List<Player> players = playersDAO.findPlayers();

        model.addAttribute("players", players);

        return "players-list";
    }
}
