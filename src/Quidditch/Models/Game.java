package Quidditch.Models;

import java.util.HashMap;

public class Game {
    private HashMap <Team, Integer> scoreboard;

    private static int gameCount;

    static {
        gameCount = 0;
    }

    public Game(Team home, Team away) {
       this.scoreboard = new HashMap<>();
       this.scoreboard.put(new Team(home), 0);
       this.scoreboard.put(new Team(away), 0);
       gameCount++;
    }
    public Integer getScore(Team team){
        return this.scoreboard.get(team);
    }
    public void setScore(Team team, Integer score){
        scoreboard.put(team, score);
    }
    public Team getTeam(String name){
        return this.scoreboard.keySet().stream()
                .filter(key -> key.getHouse().equals(name))
                .findFirst()
                .orElse(null);
    }
}
//TODO Quidditch Part 3 Task 5 https://www.learnthepart.com/course/2dfda34d-6bbc-4bd5-8f45-d5999de2f514/13ce475e-f36a-4d92-9e4c-000bf85c0c14