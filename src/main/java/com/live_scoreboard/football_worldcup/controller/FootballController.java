package com.live_scoreboard.football_worldcup.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.live_scoreboard.football_worldcup.GlobalFootballVariables;
import com.live_scoreboard.football_worldcup.model.FootballModel;
import com.live_scoreboard.football_worldcup.service.FootballService;

public class FootballController {
        private FootballService _footballService;


        //TEST code will detect errors if we do mistakes in constructor -------------
        FootballController(FootballService footballService) {
            _footballService = footballService; // Start with Injecting loosly coupled service..
        }
        //---------------------------------------------------------------------------
        
        //Simple HealthCheck endpoint -----------------------------------------------
        @GetMapping("/api/healthCheck")
        public @ResponseBody String HealthCheck() {
            return GlobalFootballVariables.SuccessServerMessage;
        }
        //---------------------------------------------------------------------------


        //Basic operations : Functional game operations  ----------------------------        
        @GetMapping(GlobalFootballVariables.EndPoint_StartNewGame)
        public @ResponseBody String StartNewGame(String HomeTeamName , String AwayTeamName) {
            String res = _footballService.StartNewGame(HomeTeamName, AwayTeamName);
            return res;
        }

        @GetMapping(GlobalFootballVariables.EndPoint_UpdateScore)
        public @ResponseBody String UpdateScore(String HomeTeamName , String AwayTeamName, Integer newScoreToHomeTeam, Integer newScoreToAwayTeam) {
            String res = _footballService.UpdateScore(HomeTeamName, AwayTeamName, newScoreToHomeTeam, newScoreToAwayTeam);
            return res;
        }

        @GetMapping(GlobalFootballVariables.EndPoint_FinishGame)
        public @ResponseBody String FinishGame(String HomeTeamName , String AwayTeamName) {
            String res = _footballService.FinishGame(HomeTeamName, AwayTeamName);
            return res;
        }

        @GetMapping(GlobalFootballVariables.EndPoint_GetSummary)
        public @ResponseBody String GetSummary() {
            List<FootballModel> model = _footballService.getGameSummary();
            JSONObject jo = new JSONObject(model);
            return jo.toString();
        }
        //---------------------------------------------------------------------------
}
