package Quidditch;

import Quidditch.Models.Game;
import Quidditch.Models.Team;

public class Main {

    public static void main (String[] args){

        System.out.println("Quidditch Main starting");

        Team t1 =  new Team("GRYFFINDOR", "Oliver", "Harry",
                new String[] {"Angelina", "Ginny", "Katie"});

        Team t2 = new Team("SLYTHERIN", "Vincent",  "Draco",
                new String[] {"Bridget", "Harper", "Malcolm"});

        Game g = new Game(t1,t2);

        g.setScore(t1, 3);
        //System.out.println(t1);

        System.out.println(g.getScore(t1));

       // System.out.println(g.getScore(t2));


    }
}
