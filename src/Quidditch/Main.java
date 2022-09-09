package Quidditch;

import Quidditch.Models.Game;
import Quidditch.Models.Team;

public class Main {

    public static void main (String[] args){
//TODO Quidditch Part 7 Task 1 https://www.learnthepart.com/course/2dfda34d-6bbc-4bd5-8f45-d5999de2f514/444e9e67-95b8-4f8f-b8f3-0538b71b09c3

        System.out.println("Quidditch Main starting");

        Team t1 =  new Team("GRYFFINDOR", "Oliver", "Harry",
                new String[] {"Angelina", "Ginny", "Katie"});

        Team t2 = new Team("SLYTHERIN", "Vincent",  "Draco",
                new String[] {"Bridget", "Harper", "Malcolm"});

        Game g = new Game(t1,t2);

        System.out.println("Team 1 score: " + g.getScore(t1));
        System.out.println("Team 2 score: " + g.getScore(t2));
        g.setScore(t1, 50);
        System.out.println("Team 1 score: " + g.getScore(g.getTeam("GRYFFINDOR")));
        System.out.println("Team 2 score: " + g.getScore(t2));

        Game g2 = new Game(t1,t2);

        System.out.println(g.random(5));
        System.out.println(g.random(5));
        System.out.println(g.random(5));
        System.out.println(g.random(5));
        System.out.println(g.random(5));
        System.out.println(g.random(5));


    }
}
