package com.live_scoreboard.football_worldcup.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
                if( iterable_element.getHomeTeamName().equals(HomeTeamName) && iterable_element.getAwayTeamName().equals(AwayTeamName)
                && iterable_element.getGameStatus().equals(GlobalFootballVariables.GameStatus.IN_PROGRESS)
                ) {
                    recordCount++;
                }
            }

            //Check if any game which is In_Progress has found.
            if(recordCount > 0) {
                return GlobalFootballVariables.ErrorGameAlreadyStarted;
            } 
            else {
                FootballModel game = new FootballModel();

                //set values
                game.setHomeTeamName(HomeTeamName);
                game.setAwayTeamName(AwayTeamName);
                game.setHomeTeamScore(GlobalFootballVariables.FootballInitialScore);
                game.setAwayTeamScore(GlobalFootballVariables.FootballInitialScore);

                //Update the status
                game.setGameStatus(GlobalFootballVariables.GameStatus.IN_PROGRESS);

                //Update score
                game.setTotalsOfScore(game.getHomeTeamScore() + game.getAwayTeamScore());
        
                //Update list
                GlobalFootballVariables.ScoreBoard.add(game);

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
                if(iterable_element.getHomeTeamName().equals(HomeTeamName) 
                && iterable_element.getAwayTeamName().equals(AwayTeamName)) 
                {                    
                    // Get current Unix Time Stamp.
                    long currentDate = Instant.now().getEpochSecond(); 

                    //Update new values.
                    iterable_element.setHomeTeamScore(newScoreToHomeTeam);
                    iterable_element.setAwayTeamScore(newScoreToAwayTeam);
                    iterable_element.setTotalsOfScore( newScoreToHomeTeam + newScoreToAwayTeam);
                    iterable_element.setGameUpdateTime(currentDate);

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
                    iterable_element.getHomeTeamName().equals(HomeTeamName)
                    && iterable_element.getAwayTeamName().equals(AwayTeamName)
                    && iterable_element.getGameStatus().equals(GlobalFootballVariables.GameStatus.IN_PROGRESS)
                ) 
                {                    
                    // Get current Unix Time Stamp.
                    long currentDate = Instant.now().getEpochSecond(); 

                    //Update new values.
                    iterable_element.setGameFinishTime(currentDate);

                    //Update the status : THIS IS NOT NECESSARY BUT LEFT FOR FUTURE USE CASES
                    iterable_element.setGameStatus(GameStatus.FINISHED);

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
    public List<String> getGameSummary() {

        //Order all games by TotalsOfScore        
        Collections.sort(
            GlobalFootballVariables.ScoreBoard, // Collection we want to order
            Comparator.comparing(FootballModel::getTotalsOfScore) // Ordering by TotalsOfScore
            .reversed() // Default order work as Ascending
            ); 

        // group by score : Stream API is used for group oepration.
        Map<Integer, List<FootballModel>> gamesByScore = GlobalFootballVariables.ScoreBoard.stream()
        .collect(Collectors.groupingBy(FootballModel::getTotalsOfScore));

        //main collection stores sub lists
        ArrayList<List<FootballModel>> listOfSameCrose =  new ArrayList<List<FootballModel>>();

        for(Map.Entry<Integer, List<FootballModel>> entry : gamesByScore.entrySet()) {
            
            // Get Key from Kay-Value pairs of the hashmap
            Integer key = entry.getKey();            

            //get a list from key
            List<FootballModel> model = gamesByScore.get(key);

            //Order each list by GameFinishTime
            Collections.sort(model, Comparator.comparing(FootballModel::getGameFinishTime).reversed());

            //add all Lists to main collection
            listOfSameCrose.add(model);
        }
        

        //Prepare final List of games.
        ArrayList<FootballModel> FinalList = new ArrayList<FootballModel>();

        //Loop each sublist
        for (List<FootballModel> item : listOfSameCrose) {
            // Loop each game in the sublists
            for (FootballModel footballModel : item) {
                FinalList.add(footballModel);
            }            
        }

        //Reverse final list for Decending order 
        Collections.reverse(FinalList);


        //Just Readable Scoreboard with additional typo
        List<String> tempScoreBoardList = new ArrayList<String>();    

        for(Integer index = 0 ; index <FinalList.size() ; index++ ) {

            // First index is 0, so make it start from 1 to make  more readable
            Integer gameNumber = index + 1 ;

            // Make readble string phrases
            tempScoreBoardList.add(
                gameNumber.toString() + ". "
                + FinalList.get(index).getHomeTeamName() + " " 
                + FinalList.get(index).getHomeTeamScore() + " - " 
                + FinalList.get(index).getAwayTeamName() + " " 
                + FinalList.get(index).getAwayTeamScore());            
        }        

        return tempScoreBoardList;
    }    
}
