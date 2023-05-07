package com.live_scoreboard.football_worldcup.service;

import java.util.ArrayList;
import java.util.List;

import com.live_scoreboard.football_worldcup.GlobalFootballVariables;
import com.live_scoreboard.football_worldcup.model.FootballModel;

public class FootballService implements IFootballService {

    //Dynamic colelction to Store game-scores
    List<FootballModel> ScoreBoard = new ArrayList<FootballModel>();

    @Override
    public String StartNewGame(String HomeTeamName, String AwayTeamName) {
        try {
            //TODO : Automapper will be good here.
            FootballModel model = new FootballModel();
            model.HomeTeamName = HomeTeamName;
            model.AwayTeamName = AwayTeamName;
            model.HomeTeamScore = GlobalFootballVariables.FootballInitialScore;
            model.AwayTeamScore = GlobalFootballVariables.FootballInitialScore;
            model.GameStatus = GlobalFootballVariables.GameStatus.STARTED;
            model.TotalsOfScore = model.HomeTeamScore + model.AwayTeamScore;
    
            ScoreBoard.add(model);
            return GlobalFootballVariables.SuccessResult;
        } catch (Exception ex) {
            //Logging logics will be here.
            return GlobalFootballVariables.ErrorResult + " : " + ex.getMessage();
        }
    }

    @Override
    public String UpdateScore(String HomeTeamName, String AwayTeamName, Integer newScoreToHomeTeam,Integer newScoreToAwayTeam) {        
        try {        
            //Todo : lojics will be here..
            return GlobalFootballVariables.SuccessResult;
        } catch (Exception ex) {
            // TODO: handle exception
            return GlobalFootballVariables.ErrorResult + " : " + ex.getMessage();
        }        
    }

    @Override
    public String FinishGame(String HomeTeamName, String AwayTeamName) {
        try {        
            //Todo : lojics will be here..
            return GlobalFootballVariables.SuccessResult;
        } catch (Exception ex) {
            // TODO: handle exception
            return GlobalFootballVariables.ErrorResult + " : " + ex.getMessage();
        }                
    }

    @Override
    public List<FootballModel> getGameSummary() {
        //Todo : lojics will be here..
        return ScoreBoard;
    }
    
    
}
