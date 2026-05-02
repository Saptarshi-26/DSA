package MultiThreading.async_Order_Processing_System;

import javax.swing.plaf.FontUIResource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(3);

        Order o1 = new Order(1, 2000);
        Order o2 = new Order(2, 5000);
        Order o3 = new Order(3, 3000);
        Order o4 = new Order(4, 7000);

        Inventory inventory = new Inventory();

        Order_Processor orderProcessor = new Order_Processor();

        Future<String> f1 = ex.submit(()->orderProcessor.take_order(inventory,o1));
        Future<String> f2 = ex.submit(()->orderProcessor.take_order(inventory,o2));
        Future<String> f3 = ex.submit(()->orderProcessor.take_order(inventory,o3));
        Future<String> f4 = ex.submit(()->orderProcessor.take_order(inventory,o4));

        ex.shutdown();

        System.out.println(f1.get()+" "+f2.get()+" "+f3.get()+" "+f4.get()+" ");


    }
}
