package Quidditch;

import Quidditch.Models.Game;
import Quidditch.Models.Team;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    static final String TEAMS_FILE = "src/Quidditch/teams.txt";
    static final String PLAYS_FILE = "src/Quidditch/plays.txt";
    static Game g;
    public static void main (String[] args){

        System.out.println("Quidditch Main starting");
/*
        Team t1 =  new Team("GRYFFINDOR", "Oliver", "Harry",
                new String[] {"Angelina", "Ginny", "Katie"});

        Team t2 = new Team("SLYTHERIN", "Vincent",  "Draco",
                new String[] {"Bridget", "Harper", "Malcolm"});


        g = new Game(t1,t2);

        System.out.println("Team 1 score: " + g.getScore(t1));
        System.out.println("Team 2 score: " + g.getScore(t2));
        g.setScore(t1, 50);
        System.out.println("Team 1 score: " + g.getScore(g.getTeam("GRYFFINDOR")));
        System.out.println("Team 2 score: " + g.getScore(t2));
*/
        try{
            String[][] data = getData();
            g = new Game(
                    new Team(data[0][0], data[0][1], data[0][2], new String[] {data[0][3], data[0][4], data[0][5]}),
                    new Team(data[1][0], data[1][1], data[1][2], new String[] {data[1][3], data[1][4], data[1][5]})
            );
            startGame();
            printResult();
        }catch(FileNotFoundException e){
            System.out.println("Error: File not found. " + e.getMessage());
        }

    }

    public static String[][] getData() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(TEAMS_FILE);
        Scanner scanfile= new Scanner(fis);
        String[] lines = new String[]{scanfile.nextLine(), scanfile.nextLine()};
        scanfile.close();
        return new String[][]{
                lines[0].split(","), lines[1].split(",")
        };
    }

    public static void startGame() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(PLAYS_FILE);
        Scanner scanfile = new Scanner(fis);
        while(scanfile.hasNextLine()){
            System.out.println("\n" + g.simulate(scanfile.nextLine()) + "\n");
            wait(2);
        }
        scanfile.close();
    }

    public static void printResult(){
        Team gryf = g.getTeam("GRYFFINDOR");
        Team slyth = g.getTeam("SLYTHERIN");
        Team winner = g.getScore(gryf) > g.getScore(slyth) ? gryf : slyth;
        System.out.println("\nGRYFFINDOR: " + g.getScore(gryf) + "\nSLYTHERIN: " + g.getScore(slyth));
        System.out.println("\nThe winner is: " + winner.getHouse());
    }

    public static void wait(int sec){
        try{
            TimeUnit.SECONDS.sleep(sec);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
