package Section26.GlobalSuperstore;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    static final String SALES_FILE = "sales.csv";
    static final String FILE_PATH = "Section26.GlobalSuperstore.data\\sales.csv";
    static final String SALES = "data/sales.csv"; //Use backslash Windows users

    public static void main (String[] args){
        try {
           // Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(SALES).toURI());
            average();

        }catch (Exception e){
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
    public static double average(){
        try{
            Path path1 = Paths.get(Thread.currentThread().getContextClassLoader().getResource(FILE_PATH).toURI());
            Files.lines(path1).forEach(System.out::println);
            return 1;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
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
}
