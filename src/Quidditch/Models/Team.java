package Quidditch.Models;

import java.util.Arrays;

public class Team {
    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";

    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers;

    public Team(String house, String keeper, String seeker, String[] chasers) {
        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;
        this.chasers = Arrays.copyOf(chasers, chasers.length);
        //TODO Quidditch Part 2 Task 1: https://www.learnthepart.com/course/2dfda34d-6bbc-4bd5-8f45-d5999de2f514/5bace35c-45c8-4cbc-89c1-2e5cc45766eb
    }

    public Team(Team t){
        this.house = t.house;
        this.keeper = t.keeper;
        this.seeker  = t.seeker;
        this.chasers = Arrays.copyOf(t.chasers, t.chasers.length);

    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(String keeper) {
        this.keeper = keeper;
    }

    public String getSeeker() {
        return seeker;
    }

    public void setSeeker(String seeker) {
        this.seeker = seeker;
    }

    public String getChasers(int index) {
        return chasers[index];
    }

    public void setChasers(String name, int index) {
        this.chasers[index] = name;
    }

    public String toString(){
        return "House: " + this.house + "\n" +
                "Keeper: " + this.keeper + "\n" +
                "Seeker: "  + this.seeker + "\n" +
                "Chasers: " + Arrays.toString(this.chasers) + "\n";
    }

    public static String getPositionChaser(){
        return POSITION_CHASER;
    }
    public static String getPositionSeeker(){
        return POSITION_SEEKER;
    }
    public static String getPositionKeeper(){
        return POSITION_KEEPER;
    }
}
