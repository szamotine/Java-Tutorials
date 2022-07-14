package Section18.Dealership;

import Section18.Dealership.models.Car;
import Section18.Dealership.models.Dealership;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Car[] cars = new Car[] {
                new Car("Nissan", 5000),
                new Car(".", 12000),
        };
        cars[1].setMake("Honda");
        cars[1].setPrice(8500);

        Dealership dealership = new Dealership(cars);

        System.out.println("\n************* JAVA DEALERSHIP *************");
        while (true) {
            System.out.println(dealership);
            System.out.print("Enter the spot number of the car you want to buy: ");
            try {
                int spot = scan.nextInt();
                dealership.sell(spot);
                if (dealership.isEmpty()){
                    System.out.println("We're all sold out");
                    break;
                }
            }catch (InputMismatchException e){
                String error = scan.nextLine();
                System.out.println("Invalid Input");
                continue;
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Please choose a valid spot");
                continue;
            }
            System.out.println("Type 'yes' if you would like to continue shopping");
            scan.nextLine();
            String endStatement = scan.nextLine();
            if (!endStatement.equals("yes")){
                break;
            }


        }

        scan.close();

    }
}
