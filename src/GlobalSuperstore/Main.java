package GlobalSuperstore;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    static final String SALES = "src\\GlobalSuperStore\\Data\\sales.csv"; //Use backslash Windows users
    static long time;
    static double averageFurniture;
    static double averageOfficeSupplies;
    static double averageTechnology;
    static double totalAverage;


    public static void main(String[] args) {


        try {
            time = System.nanoTime();

            Path path = Paths.get(SALES);
            ExecutorService executor = Executors.newFixedThreadPool(4);
            Future<Double> future2 =  executor.submit(() -> average(path, "Furniture"));
            Future<Double> future3 =  executor.submit(() -> average(path, "Technology") );
            Future<Double> future4 =   executor.submit(() -> average(path, "Office Supplies"));
            Future<Double> future5 =   executor.submit(() -> average(path, "Office Supplies"));

            /*
            //calculate average sales of "Furniture" here
            Callable<Double> callable2 = () -> average(path, "Furniture") ;
            FutureTask<Double> future2 = new FutureTask<>(callable2);
            Thread thread2 = new Thread(future2);
            //Thread thread2 = new Thread( () -> averageFurniture = average(path, "Furniture"));

            //System.out.println("Thread 2 state: " + thread2.getState());
            //calculate average sales of "Technology" here
            Callable<Double> callable3 = () -> average(path, "Technology") ;
            FutureTask<Double> future3 = new FutureTask<>(callable3);
            Thread thread3 = new Thread(future3);
            //Thread thread3 = new Thread( () -> averageTechnology =  average(path, "Technology"));
            //calculate average sales of "Office Supplies" here
            Callable<Double> callable4 = () -> average(path, "Office Supplies") ;
            FutureTask<Double> future4 = new FutureTask<>(callable4);
            Thread thread4 = new Thread(future4);
            //Thread thread4 = new Thread(() -> averageOfficeSupplies =  average(path, "Office Supplies"));
            //calculate total average of sales here
            Callable<Double> callable5 = () -> totalAverage(path) ;
            FutureTask<Double> future5 = new FutureTask<>(callable5);
            Thread thread5 = new Thread(future5);
            //Thread thread5 = new Thread(() -> totalAverage = totalAverage(path));

            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();

             */

            time = System.nanoTime() - time;
            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter your name to access the Global Superstore dataset: ");
          String name = "serguei";
            System.out.println("Access Denied. We apologize for the inconvenience. Have a good day " + name + "." + "Time: " + time);
            scan.close();
            try{
                /*
                thread2.join();
                thread3.join();
                thread4.join();
                thread5.join();
                 */
                averageFurniture = future2.get();
                averageTechnology = future3.get();
                averageOfficeSupplies = future4.get();
                totalAverage = future5.get();
                executor.shutdown();


            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
            System.out.println("\nThank you " + name + ". The average sales for Global Superstore are:\n");
            System.out.println("Average Furniture Sales: " + averageFurniture);
            System.out.println("Average Technology Sales: " + averageTechnology);
            System.out.println("Average Office Supplies Sales: " + averageOfficeSupplies);
            System.out.println("Total Average: " + totalAverage);




        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Function name: average
     * @param path (Path)
     * @param category (String)
     * @return Double
     *
     * Inside the function:
     *   1. Runs through every line from the CSV file as a stream.
     *   2. Maps every element in the stream to an array of three String values.
     *   3. Filters every value by the @param category
     *   4. Maps every element in the stream to a double (price * quantity).
     *   5. Applies the terminal operation average.
     *   6. Returns the average as double.
     *
     */
    public static double average(Path path, String category){

        try{
           return  Files.lines(path)
                    .skip(1)
                    .map(line -> line.split(","))
                    .filter(values -> values[0].equals(category))
                    .mapToDouble(values -> Double.parseDouble(values[1]) * Double.parseDouble(values[2]))
                    .average().getAsDouble();

        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0.0;
        }
    }



    /**
     * Function name: totalAverage
     * @param path (Path)
     * @return Double
     *
     * Inside the function:
     *   1. Runs through every line from the CSV file as a stream.
     *   2. Maps every element in the stream to an array of three values.
     *   3. Maps every element in the stream to a double: (price * quantity).
     *   4. Applies the terminal operation average.
     *   5. Returns the average as double.
     */
    public static double totalAverage(Path path){
        //TODO: https://www.learnthepart.com/course/2dfda34d-6bbc-4bd5-8f45-d5999de2f514/cd9e6988-e1e6-4d38-974f-3b9fa94b8858

        try{
            return Files.lines(path)
                    .skip(1)
                    .map(line -> line.split(","))
                    .mapToDouble((values -> Double.parseDouble(values[1]) * Double.parseDouble(values[2])))
                    .average().getAsDouble();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 0.0;
        }
    }


}
