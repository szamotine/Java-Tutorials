package Quidditch;

import Quidditch.Models.Team;

public class Main {

    public static void main (String[] args){

        System.out.println("Quidditch Main starting");

        Team t1 =  new Team("GRYFFINDOR", "Oliver", "Harry",
                new String[] {"Angelina", "Ginny", "Katie"});

        Team t2 = new Team("SLYTHERIN", "Vincent",  "Draco",
                new String[] {"Bridget", "Harper", "Malcolm"});

        System.out.println(t1);

        System.out.println(t2);

    }
}
