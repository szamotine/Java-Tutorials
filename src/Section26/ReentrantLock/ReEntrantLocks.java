package Section26.ReentrantLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;


public class ReEntrantLocks {

    static int counter = 0;

    public static void main(String[] args) {

        int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);

        //Latch opens after it counts down to 0
        int numberOftasks = 4;
        CountDownLatch latch = new CountDownLatch(numberOftasks);
        ReentrantLock lock = new ReentrantLock();

        for (int i = 0; i < numberOftasks; i++) {
            executorService.submit(()->task(lock, latch));
        }

        /*
        Thread thread1 = new Thread(() -> task(lock, latch));
        Thread thread2 = new Thread(() -> task(lock, latch));
        Thread thread3 = new Thread(() -> task(lock, latch));
        Thread thread4 = new Thread(() -> task(lock, latch));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

         */

        try{
            System.out.println("Awaiting Latch, counter = " + counter);
            latch.await();
            System.out.println("Latch Complete, counter = " + counter);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            executorService.shutdown();
        }


    }

    public static void task(ReentrantLock lock1, CountDownLatch latch) {
        //some really long operations that need to run in the background...
        for (int i = 0; i < 10000; i++) {
            lock1.lock();
            counter++; // there happens to be a line that updates the counter variable.
            lock1.unlock();
        }
        latch.countDown();
        //more really long operations...
    }
}
