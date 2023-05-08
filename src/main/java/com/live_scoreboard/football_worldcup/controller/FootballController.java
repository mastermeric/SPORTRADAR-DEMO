package com.live_scoreboard.football_worldcup.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.live_scoreboard.football_worldcup.GlobalFootballVariables;
import com.live_scoreboard.football_worldcup.model.FootballModel;
import com.live_scoreboard.football_worldcup.service.FootballService;


@RestController
public class FootballController {
        private FootballService _footballService = new FootballService();        

        /*
        //TEST code will detect errors if we do mistakes in constructor -------------
        FootballController(FootballService footballService) {
            _footballService = footballService; // Start with Injecting loosly coupled service..
        }
        //---------------------------------------------------------------------------
        */
        
        //Simple HealthCheck endpoint -----------------------------------------------
        @GetMapping(GlobalFootballVariables.EndPoint_HealthCheck)
        public String HealthCheck() {
            return GlobalFootballVariables.SuccessServerMessage;
        }
        //---------------------------------------------------------------------------


        

        //Basic operations : Functional game operations  ----------------------------        
        @GetMapping( GlobalFootballVariables.EndPoint_StartNewGame + "/{HomeTeamName}/{AwayTeamName}")
        public @ResponseBody String StartNewGame( 
            @PathVariable("HomeTeamName") String HomeTeamName 
            ,@PathVariable("AwayTeamName") String AwayTeamName)
            {
                String res = _footballService.StartNewGame(HomeTeamName, AwayTeamName);
                return res;
            }

        @GetMapping(GlobalFootballVariables.EndPoint_UpdateScore+ "/{HomeTeamName}/{AwayTeamName}/{newScoreToHomeTeam}/{newScoreToAwayTeam}")
        public @ResponseBody String UpdateScore(
            @PathVariable("HomeTeamName") String HomeTeamName 
            , @PathVariable("AwayTeamName") String AwayTeamName
            , @PathVariable("newScoreToHomeTeam") Integer newScoreToHomeTeam
            , @PathVariable("newScoreToAwayTeam") Integer newScoreToAwayTeam) 

            {
                String res = _footballService.UpdateScore(HomeTeamName, AwayTeamName, newScoreToHomeTeam, newScoreToAwayTeam);
                return res;
        }

        @GetMapping(GlobalFootballVariables.EndPoint_FinishGame + "/{HomeTeamName}/{AwayTeamName}")
        public @ResponseBody String FinishGame(
            @PathVariable("HomeTeamName") String HomeTeamName 
            ,@PathVariable("AwayTeamName") String AwayTeamName) 
            {
                String res = _footballService.FinishGame(HomeTeamName, AwayTeamName);
                return res;
            }

        @GetMapping(GlobalFootballVariables.EndPoint_GetSummary)
        public @ResponseBody List<FootballModel> GetSummary() {
            List<FootballModel> model = _footballService.getGameSummary();
            return model;
        }
        //---------------------------------------------------------------------------
        
}
