package com.live_scoreboard.football_worldcup.model;

import java.util.Date;

import com.live_scoreboard.football_worldcup.GlobalFootballVariables.GameStatus;

public class FootballModel {
    public String HomeTeamName ;
    public String AwayTeamName ;
    public Integer HomeTeamScore;
    public Integer AwayTeamScore;
    public Integer TotalsOfScore ;  // TotalsOfScore = HomeTeamScore + AwayTeamScore;
    public GameStatus GameStatus;
    public Date GameStartTime;
    public Date GameFinishTime;
}
