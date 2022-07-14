package VendingMachine;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){

         Item[][] items = new Item[][] {
             { new Item("Pepsi", 1.99, 3) , new Item("Fresca", 1.49, 3), new Item("Brisk", 2.49, 2) },
             { new Item("Fanta", 1.99, 2) , new Item("Barq's", 1.49, 2), new Item("A & W", 2.49, 3) },
             { new Item("Crush", 1.99, 2) , new Item("C-Cola", 1.49, 2), new Item("Berry", 2.49, 0) }
         };

         Machine machine = new Machine(items);


         //items[2][1].setPrice(2.99);

         //machine.setItems(new Item("C-Cola", 2.99, 2),2,1);

        //machine.dispense(0,0);
        //machine.dispense(0,0);
        while(true) {
            System.out.println("\n------Machine contents-----" + machine);
            System.out.println("Pick a row from 1 to 3");
            int row = scan.nextInt() - 1;
           if (!checkEntry(row)) continue;
           System.out.println("Pick a column from 1 to 3");
            int column = scan.nextInt() - 1;
            if (!checkEntry(column)) continue;
            if (machine.dispense(row, column)) {
                System.out.println("Dispensing " + machine.getItems(row, column).getName());
            } else {
                System.out.println("Sorry, " + machine.getItems(row, column).getName() + " is not available");
                System.out.println("\nPress 1 to purchase a different item");

                if (scan.nextInt() != 1){
                    checkEntry(98);
                }
            }
        }
    }
    public static boolean checkEntry(int number){
        if (number == 98){
            System.out.println("Exiting System");
            scan.close();
            System.exit(0);
        }
        if (number < 0 || number > 3){
            System.out.println("Invalid number, please choose again");
            return false;
        }

        return true;

    }
}
