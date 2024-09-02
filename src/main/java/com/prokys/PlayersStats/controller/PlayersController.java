package com.prokys.PlayersStats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/players")
public class PlayersController {

    @GetMapping("/")
    public String baseMapping(){
        return "Hello";
    }
}
