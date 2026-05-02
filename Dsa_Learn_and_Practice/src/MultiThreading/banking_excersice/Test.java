package MultiThreading.banking_excersice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Account a= new Account(1,10000);
        Account a1= new Account(2,10000);
        Account a2= new Account(3,10000);
        Account a3= new Account(4,10000);

         Transfer_1 transfer = new Transfer_1();
//        Thread t1 = new Thread(()->transfer.transfer(a,a1,150));
//        Thread t2 = new Thread(()->transfer.transfer(a1,a,200));
//        Thread t3 = new Thread(()->transfer.transfer(a3,a,709));
//        Thread t4 = new Thread(()->transfer.transfer(a2,a3,709));

//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
        ExecutorService ex = Executors.newFixedThreadPool(3);
        Future<Boolean> f1 = ex.submit(()->transfer.transfer(a,a1,2000));
        Future<Boolean> f2 = ex.submit(()->transfer.transfer(a2,a1,3400));
        Future<Boolean> f3 =ex.submit(()->transfer.transfer(a3,a2,2332));
        Future<Boolean> f4 =ex.submit(()->transfer.transfer(a3,a1,232));

        ex.shutdown();

        System.out.println(f1.get()+" "+f2.get()+" "+ f3.get()+" "+f4.get());



    }
}
