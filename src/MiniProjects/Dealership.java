package MiniProjects;

import java.util.Scanner;

public class Dealership {

    public static void main(String [] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Java Dealership");

        System.out.println("Select option a to buy a car");
        System.out.println("Select option b to sell a car");
        String option = scan.nextLine(); // nextLine stores as a string

        switch (option){
            case "a": System.out.println("What is your budget?");
            int budget = scan.nextInt();
            if (budget > 10000){
                System.out.println("Great, a Nissan Altima is available");
                System.out.println("\nDo you have insurance? Write 'yes' or 'no'");
                scan.nextLine();
                String insurance = scan.nextLine();
                System.out.println("\nDo you have a drivers license? Write 'yes' or 'no'");
                String license = scan.nextLine();
                System.out.println("\nWhat is your credit score?");
                int creditScore = scan.nextInt();
                if (insurance.equals("yes") && license.equals("yes") && creditScore > 660){
                    System.out.println("Sold! Pleasure doing business with you");
                }else{
                    System.out.println("Sorry, you're not eligible");
                }
            }else{
                System.out.println("Sorry, we don't sell cars under 10000");
            }
            break;
            case "b":
                System.out.println("What is your car valued at?");
                int value = scan.nextInt();
                System.out.println("What is your selling price?");
                int price = scan.nextInt();
                if (value > price && price < 30000){
                    System.out.println("We will buy your car, pleasure doing business with you");
                }else{
                    System.out.println("Sorry, we're not interested");

                }
            break;
            default: System.out.println("Invalid option");
            scan.close();

        }
    }



}
