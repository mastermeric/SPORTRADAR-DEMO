package com.live_scoreboard.football_worldcup;

public class GlobalFootballVariables {
    //Initial values maybe needed different defaults.
    public static Integer FootballInitialScore = 0;

    //Endpoints 
    public static final String EndPoint_HealthCheck = "/api/healthCheck";
	public static final String  EndPoint_StartNewGame = "/api/startNewGame";
	public static final String EndPoint_UpdateScore = "/api/updateScore";
	public static final String EndPoint_FinishGame = "/api/finishGame";
	public static final String EndPoint_GetSummary= "/api/getSummary";

    //String messages
    public static String SuccessServerMessage = "Server-Is-Running";
    public static String SuccessResult = "OK";
    public static String ErrorResult = "NOK";

    //Enums
    public enum GameStatus {
        STARTED, // Also mans that Game in progress..
        FINISHED,
      }
}
