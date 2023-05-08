package com.live_scoreboard.football_worldcup.model;
import com.live_scoreboard.football_worldcup.GlobalFootballVariables.GameStatus;

public class FootballModel implements Comparable<FootballModel> {
    private String HomeTeamName ;
    private String AwayTeamName ;
    private Integer HomeTeamScore;
    private Integer AwayTeamScore;
    private Integer TotalsOfScore ;  // TotalsOfScore = HomeTeamScore + AwayTeamScore;
    private GameStatus GameStatus;        
    private long GameStartTime; 
    private long GameFinishTime;
    private long GameUpdateTime;


    public String getHomeTeamName() { return HomeTeamName; }
    public void setHomeTeamName(String homeTeamName) { HomeTeamName = homeTeamName; }

    public String getAwayTeamName() { return AwayTeamName; }
    public void setAwayTeamName(String awayTeamName) { AwayTeamName = awayTeamName; }

    public Integer getHomeTeamScore() { return HomeTeamScore; }
    public void setHomeTeamScore(Integer homeTeamScore) { HomeTeamScore = homeTeamScore; }

    public Integer getAwayTeamScore() { return AwayTeamScore; }
    public void setAwayTeamScore(Integer awayTeamScore) { AwayTeamScore = awayTeamScore; }

    public Integer getTotalsOfScore() { return TotalsOfScore; }
    public void setTotalsOfScore(Integer totalsOfScore) { TotalsOfScore = totalsOfScore; }     

    public GameStatus getGameStatus() { return GameStatus; }
    public void setGameStatus(GameStatus gameStatus) { GameStatus = gameStatus; }
    
    public long getGameStartTime() { return GameStartTime; }
    public void setGameStartTime(long gameStartTime) { GameStartTime = gameStartTime; }

    public long getGameFinishTime() { return GameFinishTime; }
    public void setGameFinishTime(long gameFinishTime) { GameFinishTime = gameFinishTime; }

    public long getGameUpdateTime() { return GameUpdateTime; }
    public void setGameUpdateTime(long gameUpdateTime) { GameUpdateTime = gameUpdateTime;
    }
    
    
    @Override
    public int compareTo(FootballModel arg0) {
        return getTotalsOfScore().compareTo(arg0.getTotalsOfScore());
    }    

}
