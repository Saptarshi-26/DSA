package MultiThreading.executors_Framework;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Executors_Service {
    public static void main(String[] args) {


        ExecutorService ex = Executors.newFixedThreadPool(3); // This creates an ExecutorService with
                                                                       // fixed pool of 3 worker threads.
        for (int i=0;i<10;i++) {
            int a =i;
            ex.execute(() -> System.out.println(a));
        }
        // this will not execute in sequence as three threads are used to print a

        ex.shutdown();// no new tasks are allowed to execute ,
                      // already in progress threads will finish ,
                      //but no tasks after this can occur

        //ex.execute(()-> System.out.println("hello")); -> gives reject executionException as after
        //shutdown executor service cant start=more thread executions

       ex = Executors.newFixedThreadPool(2);

        Future<Integer> f = ex.submit(()-> 5+10);
        try {
            System.out.println(f.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
        }


    }
}
