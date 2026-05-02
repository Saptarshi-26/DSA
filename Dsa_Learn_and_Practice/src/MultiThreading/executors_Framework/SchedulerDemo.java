package MultiThreading.executors_Framework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // ============================================================
        // 🔹 1. schedule() — ONE-TIME DELAYED EXECUTION
        // ============================================================

        ScheduledExecutorService ex1 = Executors.newScheduledThreadPool(3);

        ex1.schedule(() -> System.out.println("hello"), 1000, TimeUnit.MILLISECONDS);
        // Runs ONCE after 1 second (delay-based execution)

        System.out.println(ex1.schedule(() -> 1, 1000, TimeUnit.MILLISECONDS).get());
        // Callable version:
        // - Runs after 1 second
        // - Returns result via ScheduledFuture
        // - get() waits and prints result


        // ============================================================
        // 🔹 2. REPEATING TASK DEMO
        // ============================================================

        ScheduledExecutorService ex = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            long t = System.currentTimeMillis() / 1000;
            System.out.println("Start: " + t);

            try {
                Thread.sleep(3000); // task takes 3 sec
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }

            System.out.println("End:   " + (System.currentTimeMillis() / 1000));
            System.out.println("----");
        };


        // ============================================================
        // 🔹 3. scheduleAtFixedRate (CLOCK-BASED EXECUTION)
        // ============================================================

        ex.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);

        /*
        🧠 THEORY:

        - Tries to run at FIXED timestamps:
          0s, 2s, 4s, 6s...

        ✔ If task finishes EARLY:
          Example: task takes 1 sec
          → waits for next timestamp

        ✔ If task finishes LATE:
          Example: task takes 3 sec
          → misses 2s
          → starts immediately after finishing (catch-up)

        🔥 KEY IDEA:
        FixedRate = CLOCK-driven
        → tries to maintain schedule
        → may "catch up" if delayed
        */


        // ============================================================
        // 🔹 4. scheduleWithFixedDelay (COMPLETION-BASED)
        // ============================================================

        // ex.scheduleWithFixedDelay(task, 0, 2, TimeUnit.SECONDS);

        /*
        🧠 THEORY:

        - Always waits AFTER task finishes

        Flow:
        run → finish → wait 2 sec → run → finish → wait 2 sec

        Example (task = 3 sec):
        0s → start
        3s → finish
        5s → next start
        8s → finish
        10s → next start

        🔥 KEY IDEA:
        FixedDelay = COMPLETION-driven
        → no catch-up
        → always consistent gap
        */


        // ============================================================
        // 🔹 5. KEEP PROGRAM ALIVE
        // ============================================================

        Thread.sleep(12000); // let scheduled tasks run

        ex.shutdown();
        // Always shutdown executor to stop threads
    }
}