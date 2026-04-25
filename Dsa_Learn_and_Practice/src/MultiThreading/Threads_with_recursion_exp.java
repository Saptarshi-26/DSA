package MultiThreading;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Threads_with_recursion_exp {
    AtomicInteger no_ways = new AtomicInteger(0);

    void count_ways(int n) {
        if (n == 0) {
            synchronized (this) {
                no_ways.set(no_ways.get() + 1);
            }
            return;
        } else if (n < 0) return;

        Thread step_1 = new Thread(() -> count_ways(n - 1));
        Thread step_2 = new Thread(() -> count_ways(n - 2));

        step_1.start();
        step_2.start();


        try {
            step_1.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            step_2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of stairs");
        int n = sc.nextInt();
        Threads_with_recursion_exp no_ways_to_n_stairs = new Threads_with_recursion_exp();
        Thread thread = new Thread(() -> no_ways_to_n_stairs.count_ways(n));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(no_ways_to_n_stairs.no_ways.get());
    }
}
