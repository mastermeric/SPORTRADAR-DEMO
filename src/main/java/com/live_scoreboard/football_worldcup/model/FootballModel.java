package com.live_scoreboard.football_worldcup.model;

import java.util.Date;

import com.live_scoreboard.football_worldcup.GlobalFootballVariables.GameStatus;

public class FootballModel implements Comparable<FootballModel> {
    public String HomeTeamName ;
    public String AwayTeamName ;
    public Integer HomeTeamScore;
    public Integer AwayTeamScore;
    public Integer TotalsOfScore ;  // TotalsOfScore = HomeTeamScore + AwayTeamScore;
    public GameStatus GameStatus;
        
    public long GameStartTime; 
    public long GameFinishTime;
    public long GameUpdateTime;

    // Used to make collection Comparable.
    public Integer getTotalsOfScore() {
        return TotalsOfScore;
      }

    public long getGameFinishTime() {
    return GameFinishTime;
    }

    @Override
    public int compareTo(FootballModel arg0) {
        return getTotalsOfScore().compareTo(arg0.getTotalsOfScore());
    }
}
