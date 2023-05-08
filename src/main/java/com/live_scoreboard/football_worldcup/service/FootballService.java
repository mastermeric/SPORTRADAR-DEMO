package com.live_scoreboard.football_worldcup.service;

import java.util.ArrayList;
import java.util.List;
import java.time.Instant;
import com.live_scoreboard.football_worldcup.GlobalFootballVariables;
import com.live_scoreboard.football_worldcup.GlobalFootballVariables.GameStatus;
import com.live_scoreboard.football_worldcup.model.FootballModel;

public class FootballService implements IFootballService {

    @Override
    public String StartNewGame(String HomeTeamName, String AwayTeamName) {
        try {
            
            //Number of active game
            Integer recordCount = 0;

            //Check IF Same Game Exists and STATUS is STARTED (IN_PROGRESS)
            for (FootballModel iterable_element : GlobalFootballVariables.ScoreBoard) {
                if( iterable_element.HomeTeamName.equals(HomeTeamName) && iterable_element.AwayTeamName.equals(AwayTeamName)
                && iterable_element.GameStatus.equals(GlobalFootballVariables.GameStatus.IN_PROGRESS)
                ) {
                    recordCount++;
                }
            }

            //Check if any game which is In_Progress has found.
            if(recordCount > 0) {
                return GlobalFootballVariables.ErrorGameAlreadyStarted;
            } 
            else {
                FootballModel model = new FootballModel();

                //set values
                model.HomeTeamName = HomeTeamName;
                model.AwayTeamName = AwayTeamName;
                model.HomeTeamScore = GlobalFootballVariables.FootballInitialScore;
                model.AwayTeamScore = GlobalFootballVariables.FootballInitialScore;

                //Update the status
                model.GameStatus = GlobalFootballVariables.GameStatus.IN_PROGRESS;

                //Update score
                model.TotalsOfScore = model.HomeTeamScore + model.AwayTeamScore;
        
                //Update list
                GlobalFootballVariables.ScoreBoard.add(model);

                //send result
                return GlobalFootballVariables.SuccessGameStarted;
            }

        } catch (Exception ex) {
            return GlobalFootballVariables.ErrorResult + " : " + ex.getMessage();
        }
    }

    @Override
    public String UpdateScore(String HomeTeamName, String AwayTeamName, Integer newScoreToHomeTeam,Integer newScoreToAwayTeam) {        
        try {        
            
            //Number of active game
            Integer updatedRecordCount = 0;

            for (FootballModel iterable_element : GlobalFootballVariables.ScoreBoard) {
                if(iterable_element.HomeTeamName.equals(HomeTeamName) && iterable_element.AwayTeamName.equals(AwayTeamName)) {
                    
                    // Get current Unix Time Stamp.
                    long currentDate = Instant.now().getEpochSecond(); 

                    //Update new values.
                    iterable_element.HomeTeamScore = newScoreToHomeTeam;
                    iterable_element.AwayTeamScore = newScoreToAwayTeam;
                    iterable_element.TotalsOfScore = iterable_element.HomeTeamScore + iterable_element.AwayTeamScore;
                    iterable_element.GameUpdateTime = currentDate;

                    updatedRecordCount++;
                }
            }
                        
            if(updatedRecordCount == 1) {
                //send result OK if only one record is updated.
                return GlobalFootballVariables.SuccessGameUpdated;    
            }
            else {
                //send result with ERROR in all other conditions
                return GlobalFootballVariables.ErrorNoRecordFound;
            }

        } catch (Exception ex) {
            return GlobalFootballVariables.ErrorResult + " : " + ex.getMessage();
        }        
    }

    @Override
    public String FinishGame(String HomeTeamName, String AwayTeamName) {
        try {
            
            //Number of active game
            Integer recordCount = 0;
            
            for (FootballModel iterable_element : GlobalFootballVariables.ScoreBoard) {
                if(
                    //check if record exists, Also check if status is IN_PROGRESS
                    iterable_element.HomeTeamName.equals(HomeTeamName)
                    && iterable_element.AwayTeamName.equals(AwayTeamName)
                    && iterable_element.GameStatus.equals(GlobalFootballVariables.GameStatus.IN_PROGRESS)
                ) 
                {                    
                    // Get current Unix Time Stamp.
                    long currentDate = Instant.now().getEpochSecond(); 

                    //Update new values.
                    iterable_element.GameFinishTime = currentDate;

                    //Update the status : THIS IS NOT NECESSARY BUT LEFT FOR FUTURE USE CASES
                    iterable_element.GameStatus = GameStatus.FINISHED;

                    //Rmove the game from Scoreboard
                    GlobalFootballVariables.ScoreBoard.remove(iterable_element);
                    recordCount++;

                    //Return with successfull result
                    return GlobalFootballVariables.SuccessGameFinished;
                }
            }

            //Return with error if no available game to Finish
            return GlobalFootballVariables.ErrorNoRecordFound;


        } catch (Exception ex) {
            //send Exceptional error
            return GlobalFootballVariables.ErrorResult + " : " + ex.getMessage();
        }                
    }

    @Override
    public List<FootballModel> getGameSummary() {
        List<FootballModel> tempScoreBoard = new ArrayList<FootballModel>();

        for (FootballModel iterable_element : GlobalFootballVariables.ScoreBoard) {
            
        }

        return GlobalFootballVariables.ScoreBoard;
    }
    
    
}
