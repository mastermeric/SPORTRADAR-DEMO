package com.live_scoreboard.football_worldcup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.live_scoreboard.football_worldcup.GlobalFootballVariables;
import com.live_scoreboard.football_worldcup.service.FootballService;

public class FootballController {
        private FootballService _footballService;


        //TEST code will detect errors if we do mistakes in constructor -------------
        FootballController(FootballService footballService) {
            _footballService = footballService; // Start with Injecting loosly coupled service..
        }
        //---------------------------------------------------------------------------

    
    //Simple HealthCheck endpoint just to see Server is Healthy -----------------
    @GetMapping("/api/healthCheck")
    public @ResponseBody String HealthCheck() {
        return GlobalFootballVariables.SuccessServerMessage;
    }
    //---------------------------------------------------------------------------
}
