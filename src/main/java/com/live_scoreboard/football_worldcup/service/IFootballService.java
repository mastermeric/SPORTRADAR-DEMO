package com.live_scoreboard.football_worldcup.service;

import java.util.List;

import com.live_scoreboard.football_worldcup.model.FootballModel;

public interface IFootballService {
    String StartNewGame(String HomeTeamName , String AwayTeamName);
    String UpdateScore(String HomeTeamName , String AwayTeamName, Integer newScoreToHomeTeam, Integer newScoreToAwayTeam);
    String FinishGame(String HomeTeamName , String AwayTeamName);
    List<FootballModel> getGameSummary();
}
