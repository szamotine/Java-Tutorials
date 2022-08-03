package Section18.MovieStore;


import Section18.MovieStore.Model.Movie;
import Section18.MovieStore.Model.Store;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
 static Store s = new Store();
    static public void main(String[] args){

        try {
            String filename = "MoviesToLoad.txt";
            loadMovies(filename);
            System.out.println("\nMovies loaded\n\n");
            manageMovies();
        }catch (FileNotFoundException e){
            System.out.println("FNF error: " + e.getMessage());
        }finally{
            System.out.println("Process Completed");
        }




    }

    public static void manageMovies(){
        //TODO MovieStore Part 5 Task 3
        Scanner scan = new Scanner(System.in);
        String movieName;
        String action;

        manageMovie:
        while (true){
            System.out.println("\nChoose an option: \n\ta)Purchase \n\tb)Rent \n\tc)Return");
            String choice = scan.nextLine();
            switch (choice) {
                case "a":
                    System.out.println("\nEnter the name of the movie that you would like to purchase");
                     movieName = scan.nextLine();
                    if (movieName == null || movieName.isBlank()) {
                        System.out.println("\n\nThe input you provided is not valid. Please try again");
                        break;
                    }
                    if (!s.checkAvailable(movieName)) {
                        System.out.println(movieName + " is not available to be sold, it is rented out");
                        break;
                    }
                     action = "sell";
                     s.action(movieName, action);
                    break;
                case "b":
                    System.out.println("\nEnter the name of the movie that you would like to rent");
                    movieName = scan.nextLine();
                    if (movieName == null || movieName.isBlank()) {
                        System.out.println("\n\nThe input you provided is not valid. Please try again");
                        break;
                    }
                    action = "rent";
                    s.action(movieName, action);
                    break;
                case "c":
                    System.out.println("\nEnter the name of the movie that you would like to return");
                    movieName = scan.nextLine();
                    if (movieName == null || movieName.isBlank()) {
                        System.out.println("\n\nThe input you provided is not valid. Please try again");
                        break;
                    }
                    action = "return";
                    s.action(movieName, action);
                    break;
                case "d":
                   System.out.println(s.toString());
                    break;
                default:
                    System.out.println("Invalid choice");
                    break manageMovie;
            }
            System.out.println(s.toString());
        }
        System.out.println("Closing scan");
        scan.close();
    }

    public static void loadMovies(String file) throws FileNotFoundException {
        String path = "C:\\Users\\s_zam\\Desktop\\Programming\\Bootcamp\\src\\Section18\\MovieStore\\Model\\" + file;

        FileInputStream fis = new FileInputStream(path);
        Scanner scanFile = new Scanner(fis);
        while (scanFile.hasNextLine()){
            try{
                String name = scanFile.nextLine();
                String format = scanFile.nextLine();
                double rating = scanFile.nextDouble();
                Movie m = new Movie(name, format, rating);
                s.addMovie(m);
                if (scanFile.hasNextLine()) {
                    scanFile.nextLine();

                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }


        }
        scanFile.close();
    }
}
