package Section26.JoiningThreads;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    static final double TARGET = 0.5;
    static final double PRECISION = 0.0000001;
    static double[] results = new double[3];
    static double[] targets = {0.5, 0.8, 0.3};

    public static void main(String[] args) {

        //How many processors are available

        System.out.println(Runtime.getRuntime().availableProcessors());

        //Thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Double> futureTask =  executor.submit(() -> generateNumber(0));
        Future<Double> futureTask2 =  executor.submit(() -> generateNumber(1));
        Future<Double> futureTask3 =   executor.submit(() -> generateNumber(2));


        //call generateNumber here...
        //calculate precision level here...

        //Runnable is used for void functions
        // Runnable runnable = () -> result = generateNumber();
        //Thread thread2 = new Thread(runnable);

        // generateNumber returns a result -> use Callable

        //Callable<Double> callable =Main::generateNumber; // can be defined inside the futureTask instead

        /*
        //Used thread pool instead
        FutureTask<Double> futureTask = new FutureTask<>( () -> generateNumber(0));
        FutureTask<Double> futureTask2 = new FutureTask<>( () -> generateNumber(1));
        FutureTask<Double> futureTask3 = new FutureTask<>( () -> generateNumber(2));

        Thread thread2 = new Thread(futureTask);
        Thread thread3 = new Thread(futureTask2);
        Thread thread4 = new Thread(futureTask3);

        thread2.start();
        thread3.start();
        thread4.start();

         */



        try{
            //runnable
           //thread2.join();

            //callable
            results[0] = futureTask.get();
            results[1] = futureTask2.get();
            results[2] = futureTask3.get();
            executor.shutdown();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        double precision = difference(results[0], 0);
        double precision2 = difference(results[1], 1);
        double precision3 = difference(results[2], 2);

        System.out.println("The computer returned a value of: " + Arrays.toString(results));
        System.out.println("The value was generated to a precision of : " + precision + "," + precision2 + "," + precision3);
    }

    /**
     * Function name: generateNumber
     * @return double
     * 
     * Inside the function:
     *   1. Generates a number close to the TARGET to a precision of PRECISION.
     * 
     */
    public static double generateNumber(int index){
        double number = Math.random();
        double difference = difference(number, index);

        while(difference > PRECISION){
            number = Math.random();
            difference = difference(number, index);
        }
        return number;

    }

    public static double difference(double number, int index){
        return Math.abs(targets[index] - number);
    }

}
