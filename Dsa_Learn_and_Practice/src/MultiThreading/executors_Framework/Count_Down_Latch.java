package MultiThreading.executors_Framework;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Count_Down_Latch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService ex = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            int a = i;
            ex.execute(() -> {
                System.out.println("task" + a);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                latch.countDown();
            });
        }

        latch.await();
        System.out.println("wait ends after 3 threads have completed their tasks");
        CountDownLatch latch1 = new CountDownLatch(3);

        for (int i = 0; i < 2; i++) {
            int a = i;
            ex.execute(() -> {
                System.out.println("task " + a);
                latch1.countDown();
            });
        }
        latch1.await();
        // never ends as it never becomes 0 , only two threads

    }

}

