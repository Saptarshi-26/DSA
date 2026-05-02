package MultiThreading.executors_Framework;

import ooP.School.School;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Executors_Service {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        // ============================================================
        // 🔹 1. BASIC EXECUTOR (execute)
        // ============================================================

        ExecutorService ex = Executors.newFixedThreadPool(3);
        // Creates a thread pool with max 3 threads

        for (int i = 0; i < 10; i++) {
            int a = i;
            ex.execute(() -> System.out.println(a));
        }
        // execute() → runs Runnable tasks
        // Output is NOT sequential because multiple threads are used

        ex.shutdown();
        // No new tasks allowed
        // Already submitted tasks will complete


        // ============================================================
        // 🔹 2. SUBMIT + FUTURE (Basic)
        // ============================================================

        ex = Executors.newFixedThreadPool(2);

        Future<Integer> f = ex.submit(() -> 5 + 10);
        // submit() → returns Future

        try {
            System.out.println(f.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
        }
        // get() → blocks until result is ready


        // ============================================================
        // 🔹 3. Future + isDone()
        // ============================================================

        Future<Integer> f2 = ex.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1;
        });

        System.out.println(f2.isDone());
        // isDone() → checks completion WITHOUT waiting

        while (!f2.isDone()) {
            // Busy waiting (not ideal, but used here for learning)
        }

        System.out.println("f2 done");


        // ============================================================
        // 🔹 4. get(timeout)
        // ============================================================

        Future<Integer> f3 = ex.submit(() -> 1);

        f3.get(1000, TimeUnit.MILLISECONDS);
        // Waits max 1 second → avoids infinite blocking


        // ============================================================
        // 🔹 5. cancel() + interruption
        // ============================================================

        Future<?> f4 = ex.submit(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        f4.cancel(true);
        // cancel(true) → sends interrupt signal
        // Works only if task checks interruption


        // ============================================================
        // 🔹 6. invokeAll() (Batch execution)
        // ============================================================

        List<Callable<Integer>> task = new ArrayList<>();

        task.add(() -> {
            Thread.sleep(1000);
            System.out.println("1st task");
            return 1;
        });

        task.add(() -> {
            Thread.sleep(1000);
            System.out.println("2nd task");
            return 2;
        });

        task.add(() -> {
            Thread.sleep(1000);
            System.out.println("3rd task");
            return 3;
        });

        task.add(() -> {
            Thread.sleep(1000);
            System.out.println("4rth task");
            return 4;
        });

        List<Future<Integer>> futures = ex.invokeAll(task);
        // Runs ALL tasks
        // Blocks until ALL tasks finish
        // Returns List of Future


        // ============================================================
        // 🔹 7. invokeAny() (Fastest result)
        // ============================================================

        int result = ex.invokeAny(task);
        // Returns result of fastest task
        // Cancels remaining tasks


        // ============================================================
        // 🔹 8. Reading results
        // ============================================================

        for (Future<Integer> x : futures) {
            System.out.println(x.get());
        }
        // All futures are already completed here (invokeAll already waited)

        ex.shutdown();





    }
}