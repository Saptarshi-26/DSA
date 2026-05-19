package MultiThreading;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Threads_with_recursion_exp_using_ExecutersFramwork {
    AtomicInteger no_ways = new AtomicInteger(0);

    void count_ways(int n, ExecutorService executorService) {
        if (n == 0) {
            no_ways.incrementAndGet();
            return;
        } else if (n < 0) return;

        Future<?> f1 = executorService.submit(() -> count_ways(n - 1, executorService));
        Future<?> f2 = executorService.submit(() -> count_ways(n - 2, executorService));

        try {
            f1.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        try {
            f2.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);   }}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of stairs");
        int n = sc.nextInt();

        ExecutorService executorService = Executors.newCachedThreadPool();

        Threads_with_recursion_exp_using_ExecutersFramwork obj =
                new Threads_with_recursion_exp_using_ExecutersFramwork();

        Future<?> future = executorService.submit(() -> obj.count_ways(n, executorService));

        try {
            future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();

        System.out.println(obj.no_ways.get());
    }
}
