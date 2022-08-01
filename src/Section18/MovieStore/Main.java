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
        }catch (FileNotFoundException e){
            System.out.println("FNF error: " + e.getMessage());
        }finally{
            System.out.println(s.toString());
        }

        manageMovies();


    }

    public static void manageMovies(){
        //TODO MovieStore Part 5 Task 3
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("\nChoose an option: \n\ta)Purchase \n\tb)Rent \n\tc)Return");
            String choice = scan.nextLine();
            if (choice.equals("a")){
                System.out.println("choice a");

            }else if (choice.equals("b")){
                System.out.println("choice b");

            } else if (choice.equals("c")){
                System.out.println("choice c");

            }else{
                System.out.println("Invalid choice");
                break;
            }
        }
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
