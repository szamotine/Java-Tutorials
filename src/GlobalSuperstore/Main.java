package GlobalSuperstore;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    static final String SALES = "C:\\Users\\s_zam\\Desktop\\Programming\\Bootcamp\\src\\GlobalSuperStore\\Data\\sales.csv"; //Use backslash Windows users

    public static void main(String[] args) {

        try {

            Path path = Paths.get(SALES);
            //calculate average sales of "Furniture" here
            //calculate average sales of "Technology" here
            //calculate average sales of "Office Supplies" here
            //calculate total average of sales here

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
            Files.lines(path)
                    .skip(1)
                    .map(line -> line.split(","))
                    .filter(values -> values[0].equals(category))
                    .mapToDouble(values -> Double.valueOf(values[1]) * Double.valueOf(values[2]))
                    .average().getAsDouble();

        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0.0;
        }

        return 0;
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
        return 0.0;
    }


}
