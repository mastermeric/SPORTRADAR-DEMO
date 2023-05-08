package com.live_scoreboard.football_worldcup.service;
import java.util.List;

public interface IFootballService {
    String StartNewGame(String HomeTeamName , String AwayTeamName);
    String UpdateScore(String HomeTeamName , String AwayTeamName, Integer newScoreToHomeTeam, Integer newScoreToAwayTeam);
    String FinishGame(String HomeTeamName , String AwayTeamName);
    List<String> getGameSummary();
}
