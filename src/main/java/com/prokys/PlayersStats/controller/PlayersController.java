package com.prokys.PlayersStats.controller;

import com.prokys.PlayersStats.entity.Club;
import com.prokys.PlayersStats.entity.Player;
import com.prokys.PlayersStats.service.ClubsService;
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

    private ClubsService clubsService;

    public PlayersController(PlayersService service, ClubsService cService) {
        playersService = service;
        clubsService = cService;
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

        return "players-list";
    }

    @GetMapping("/profile")
    public String getPlayersProfile(@RequestParam("playerId") int playerId, Model model) {
        // find player by id
        Player player = playersService.findPlayerById(playerId);

        // add them to model
        model.addAttribute("player", player);

        if (player == null){
            return "redirect:/players";
        }
        return "players-profile";
    }

    @GetMapping("/edit")
    public String getPlayersProfileEdit(@RequestParam("playerId") int playerId, Model model) {

        // find player by id
        Player player = playersService.findPlayerById(playerId);

        // find clubs for selection
        List<Club> clubs = clubsService.findClubs();

        // add them to model
        model.addAttribute("player", player);
        model.addAttribute("clubs", clubs);

        return "players-profile-edit";
    }

    @PostMapping("/update")
    public String updatePlayer(@ModelAttribute("player") Player player){

        // update player
        playersService.updatePlayer(player);

        return "redirect:/players/profile?playerId="+player.getId();
    }

    @GetMapping("/addNewPlayer")
    public String addNewPlayer(Model model){

        // create empty player
        Player player = new Player();

        // find clubs for selection
        List<Club> clubs = clubsService.findClubs();

        // add into model
        model.addAttribute("player", player);
        model.addAttribute("clubs", clubs);

        return "players-profile-edit";
    }

    @GetMapping("/delete")
    public String deletePlayer(@RequestParam("playerId") int id){

        playersService.deletePlayer(id);

        return "redirect:/players";
    }
}
