package MiniProjects;

import java.util.Scanner;

public class RockPaperScissors {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wins = 0;
        int losses = 0;
        int total = 0;
        double winPercentage;
        boolean flag = true;
        int count = 0;
        int choice;
        boolean flagRandom = false;
        String [] choices = {"rock", "paper", "scissors"};
        String human;

        while (flag && count < 1e5) {
            try {
                System.out.println("\nChoose rock, paper, or scissors");

                if (flagRandom){
                    choice = total%3;
                    human = choices[choice];
                }else{
                     human = scan.next();
                    flagRandom = checkRandom(human);

                }




                flag = checkExit(human);
                if (!flag) {
//                    System.out.println("Breaking due to flag");
                    break;
                }

                checkInput(human);
                System.out.println("Your choice is " + human);

                String computer = Computer_move();

                if (checkWin(human, computer)) {
                    System.out.println("You won!");
                    wins++;
                } else {
                    System.out.println("You didn't win!");
                    losses++;
                }

                System.out.println("\nWin count is: " + wins);
                System.out.println("loss count is: " + losses);
                total++;
                System.out.println("Total games played: " + total);

            } catch (Exception e) {
                System.out.println("Exception occurred");
                break;
//                System.exit(0);
            } finally {
                winPercentage = ((double) wins / (double) total) * 100;
                winPercentage = Math.round(winPercentage);
                System.out.println("\nYour win percentage is: " + winPercentage + "%!");
                count ++;
            }

        }
        System.out.println("Status of flagRandom is: " + flagRandom);
        System.out.println("Closing scanner");
        scan.close();
    }

    public static String Computer_move() {
        String choice = "";
        double number = (3 * Math.random() + 1);
        int num = (int) number;

        // System.out.println("num: " + (double)num);

        if (num == 1) {
            choice = "rock";
        } else if (num == 2) {
            choice = "paper";
        } else if (num == 3) {
            choice = "scissors";
        } else {
            System.out.println("Error: invalid choice from computer");
        }
        System.out.println("Computer chose " + choice);

        return choice;
    }

    public static boolean checkWin(String human, String computer) {


        if (human.equals("rock") && computer.equals("scissors")) {
            return true;
        } else if (human.equals("paper") && computer.equals("rock")) {
            return true;
        } else if (human.equals("scissors") && computer.equals("paper")) {
            return true;
        } else if (human.equals(computer)) {
            System.out.println("It's a draw!");
            //System.exit(0);
        }
        return false;
    }

    public static void checkInput(String human) {
        if (!(human.equals("rock")) && !(human.equals("paper")) && !(human.equals("scissors")) &&
                !(human.equals("X")) &&
                !(human.equals("random  "))) {
            System.out.println("Invalid choice");
        }
    }

    public static boolean checkExit(String human) {
        if (human.equals("X")) {
            System.out.println("Exiting Program");
            return false;

//            System.exit(0);
        }
        return true;
    }

    public static boolean checkRandom(String human){
        if (human.equals("random")){
            System.out.println("Starting random run");
            return true;
        }
        return false;
    }
}
