package MultiThreading.executors_Framework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrier_example {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3); // it will wait for three threads , then will release

        ExecutorService ex = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            ex.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " waiting ");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " released \n\n");

                // CyclicBarrier can be reused unlike Countdown latch

                System.out.println(Thread.currentThread().getName() + " again waiting ");

                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Again released");


            });
        }
        ex.shutdown();


    }

}
