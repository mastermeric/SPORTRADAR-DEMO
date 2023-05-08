package com.live_scoreboard.football_worldcup.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.live_scoreboard.football_worldcup.GlobalFootballVariables;
import com.live_scoreboard.football_worldcup.service.FootballService;


@RestController
public class FootballController {
        private FootballService _footballService = new FootballService();        
        
        
        //Simple HealthCheck endpoint ==============================================
        @GetMapping(GlobalFootballVariables.EndPoint_HealthCheck)
        public ResponseEntity<String> HealthCheck() {
            try {
                return ResponseEntity.status(HttpStatus.OK).body(GlobalFootballVariables.SuccessServerMessage);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
            }            
        }
        //==========================================================================

        

        //Basic game operations  ===================================================
        @GetMapping( GlobalFootballVariables.EndPoint_StartNewGame + "/{HomeTeamName}/{AwayTeamName}")
        public ResponseEntity<String> StartNewGame( 
            @PathVariable("HomeTeamName") String HomeTeamName 
            ,@PathVariable("AwayTeamName") String AwayTeamName)
            {
                try {
                    String res = _footballService.StartNewGame(HomeTeamName, AwayTeamName);

                    if(res.contains("Error")) {
                        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(res);
                    }

                    return ResponseEntity.status(HttpStatus.OK).body(res);
                } catch (Exception e) {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
                }
            }

        @GetMapping(GlobalFootballVariables.EndPoint_UpdateScore+ "/{HomeTeamName}/{AwayTeamName}/{newScoreToHomeTeam}/{newScoreToAwayTeam}")
        public ResponseEntity<String> UpdateScore(
            @PathVariable("HomeTeamName") String HomeTeamName 
            , @PathVariable("AwayTeamName") String AwayTeamName
            , @PathVariable("newScoreToHomeTeam") Integer newScoreToHomeTeam
            , @PathVariable("newScoreToAwayTeam") Integer newScoreToAwayTeam)
            {
                try {
                    String res = _footballService.UpdateScore(HomeTeamName, AwayTeamName, newScoreToHomeTeam, newScoreToAwayTeam);

                    if(res.contains("Error")) {
                        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(res);
                    }

                    return ResponseEntity.status(HttpStatus.OK).body(res);
                } catch (Exception e) {                    
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());   
                }                
            }

        @GetMapping(GlobalFootballVariables.EndPoint_FinishGame + "/{HomeTeamName}/{AwayTeamName}")
        public ResponseEntity<String> FinishGame(
            @PathVariable("HomeTeamName") String HomeTeamName 
            ,@PathVariable("AwayTeamName") String AwayTeamName) 
            {
                try {
                    String res = _footballService.FinishGame(HomeTeamName, AwayTeamName);

                    if(res.contains("Error")) {
                        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(res);
                    }

                    return ResponseEntity.status(HttpStatus.OK).body(res);
                } catch (Exception e) {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());   
                }                
            }

        @GetMapping(GlobalFootballVariables.EndPoint_GetSummary)
        public ResponseEntity<List<String>> GetSummary() {
            
            try {                
                List<String> scoreBoardList = _footballService.getGameSummary();                
                return ResponseEntity.status(HttpStatus.OK).body(scoreBoardList);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);   
            }            
        }
        //===========================================================================
        
}
