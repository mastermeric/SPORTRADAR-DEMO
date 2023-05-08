package com.live_scoreboard.football_worldcup;

import java.util.ArrayList;
import java.util.List;

import com.live_scoreboard.football_worldcup.model.FootballModel;

public class GlobalFootballVariables {

    //Dynamic colelction to Store game-scores
    public static List<FootballModel> ScoreBoard = new ArrayList<FootballModel>() ;

    //Initial values maybe needed different defaults.
    public static Integer FootballInitialScore = 0;

    //Endpoints 
    public static final String EndPoint_HealthCheck = "/api/healthCheck";
	public static final String EndPoint_StartNewGame = "/api/startNewGame";
	public static final String EndPoint_UpdateScore = "/api/updateScore";
	public static final String EndPoint_FinishGame = "/api/finishGame";
	public static final String EndPoint_GetSummary= "/api/getSummary";

    //String messages
    public static String SuccessServerMessage = "OK. Server-Is-Running";
    public static String SuccessGameStarted = "OK. Game-Is-Started.";
    public static String SuccessGameFinished = "OK. Game-Is-Finished";
    public static String SuccessGameUpdated = "OK. Game-Is-Updated";    
    public static String SuccessResult = "OK";


    public static String ErrorResult = "Error.NOK";
    public static String ErrorNoRecordFound = "Error. No-Proper-Record-Found";    
    public static String ErrorGameAlreadyStarted = "Error. This-Game-Already-Started-Still-In-Progress";
    public static String ErrorGameAlreadyFinished = "Error. Game-Already-Finished";

    //Enums
    public enum GameStatus {
        IN_PROGRESS, // Also means that Game in progress..        
        FINISHED
      }
}
