package com.prokys.PlayersStats.controller;

import com.prokys.PlayersStats.entity.Club;
import com.prokys.PlayersStats.service.clubs.ClubsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("clubs")
public class ClubsController {

    private ClubsService clubsService;

    public ClubsController(ClubsService cService){
        clubsService = cService;
    }

    @GetMapping()
    public String getClubs(@RequestParam(name = "text", required = false)String text, Model model){

        List<Club> clubs;

        if (text != null && !text.isEmpty()){
            // get clubs with text parameter
             clubs = clubsService.findClubs(text);
        }else {
            clubs = clubsService.findClubs();
        }

        //add into model
        model.addAttribute("clubs", clubs);

        return "/clubs/clubs-list";
    }

    @GetMapping("/detail")
    public String clubDetail(@RequestParam(name = "clubId") int id, Model model){

        Club club = clubsService.findClubById(id);

        model.addAttribute("club", club);

        return "/clubs/clubs-detail";
    }

    @GetMapping("/edit")
    public String clubEdit(@RequestParam(name = "clubId") int id, Model model){

        Club club = clubsService.findClubById(id);

        model.addAttribute("club", club);

        return "/clubs/clubs-detail-edit";
    }
}
