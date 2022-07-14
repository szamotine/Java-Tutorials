package Workbook;

import java.util.Scanner;

public class Survey {
    public static void main(String [] args){


        Scanner scan = new Scanner(System.in);
        System.out.println("How old are you?");
        String age = scan.nextLine();
        System.out.println("You entered: " + age);
        scan.close();


    }
}
