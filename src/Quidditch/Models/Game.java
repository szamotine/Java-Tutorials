package Quidditch.Models;

import java.util.HashMap;

public class Game {
    private HashMap <Team, Integer> scoreboard;
    private static int gameCount;
    private final int QUAFFLE_POINTS = 10;
    private final int SNITCH_POINTS = 150;

    static {
        gameCount = 0;
    }
    public Game(Team home, Team away) {
       this.scoreboard = new HashMap<>();
       this.scoreboard.put(new Team(home), 0);
       this.scoreboard.put(new Team(away), 0);
       gameCount++;
    }
    public int getScore(Team team){
        return this.scoreboard.get(team);
    }
    public void setScore(Team team, Integer score){
        if (team == null) {
            throw new IllegalArgumentException("Team cannot be null");
        }
        scoreboard.put(team, score);
    }
    public Team getTeam(String name){
        return this.scoreboard.keySet().stream()
                .filter(key -> key.getHouse().equals(name))
                .findFirst()
                .orElse(null);
    }

    public static int getGameCount() {
        return gameCount;
    }
    public int getQUAFFLE_POINTS(){
        return QUAFFLE_POINTS;
    }

    public int getSNITCH_POINTS() {
        return SNITCH_POINTS;
    }

    public String getPlaceholder(String play){
        return play.substring(play.indexOf("<") + 1, play.indexOf(">"));
    }
    public String replacePlaceholder(String play, String placeholder, String value){

        return play.replace("<"+placeholder + ">", value);
    }
    public void quaffleScore(Team team){
        setScore(team, getScore(team) + getQUAFFLE_POINTS());
    }
    public void catchSnitch(Team team){
        setScore(team, getScore(team) + getSNITCH_POINTS());
    }

    public String simulate(String play){
        String placeholder = getPlaceholder(play);
        Team team = getRandomTeam();
        String value = "";
        if (placeholder.equals(Team.getPositionChaser())){
            quaffleScore(team);
        }else if (placeholder.equals(Team.getPositionSeeker())){
            catchSnitch(team);
        }else if (placeholder.equals(Team.getPositionKeeper())){
            value = team.getKeeper();
        }
        return replacePlaceholder(play, placeholder, value);
    }

    public Team getRandomTeam(){
        Object[] teams = scoreboard.keySet().toArray();
        return (Team)teams[random(teams.length)];
    }

    public int random(int range){
        return (int)(Math.random() * range);
    }

}
