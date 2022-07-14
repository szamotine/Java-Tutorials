package MiniProjects;

import java.util.Scanner;

public class Dice {

    public static void main(String [] args){
    /*
    * Rules:
    * User needs to pick three numbers          -> (4 3 5) -> sum = 12
    * user needs to roll the dice three times   -> (3 4 4) -> sum = 11
    * The user wins if:
    *   the sum of the dice rolls is smaller than the sum of numbers you choose
    *   And the difference between the two numbers is less than 3
    *
    *   Tasks:
    *       Roll the dice
    *       Check if the user won
    *
    * */
        Scanner scan = new Scanner(System.in);

        int roll1 = rollDice();
        int roll2 = rollDice();
        int roll3 = rollDice();

        System.out.println("Enter three numbers between 1 and 6");
        int num1 = scan.nextInt();          // skips the delimiter, skips the white space, reads next int input
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();

        checkNumber(num1);
        checkNumber(num2);
        checkNumber(num3);

        int sumNumbers = num1 + num2 + num3;
        int sumDiceRolls = roll1 + roll2 + roll3;

        System.out.println("Dice numbers are: " + roll1 + ","+ roll2 + ","+ roll3 );

        System.out.println("Sum of numbers is: " + sumNumbers);
        System.out.println("Sum of dice rolls is: " + sumDiceRolls);
        System.out.println("Difference of numbers is: " + Math.abs(sumNumbers- sumDiceRolls));

        checkWin(sumDiceRolls, sumNumbers);


        scan.close();

    }
    public static int rollDice(){
        double randomNumber = 6*Math.random() + 1;   // scales the range from 1-6
        return (int)randomNumber;                    //type cast to int
    }

    public static void checkNumber(int num){
        if (num > 0 && num < 7){
            return;
        }else{
            System.out.println("Number is out of range, shutting game down");
            System.exit(0);
        }
    }

    public static void checkWin(int sumDiceRolls, int sumNumbers){

        if (sumDiceRolls < sumNumbers && sumNumbers-sumDiceRolls <= 3){
            System.out.println("Congrats! You win!");
        }else{
            if (!(sumDiceRolls < sumNumbers)){
                System.out.println("Sorry, dice roll sum is greater than number sum");
            }
            if (!(sumNumbers-sumDiceRolls <= 3)){
                System.out.println("Sorry, difference between numbers is greater than 3");
            }
        }

    }



}
