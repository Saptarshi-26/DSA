package MultiThreading.executors_Framework;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Executors_example {
    public static void main(String[] args) {

//        Executor = task runner abstraction
//        SingleThreadExecutor = one worker + queue
//        Tasks execute sequentially


        Executor ex = Executors.newSingleThreadExecutor(); // this only have one threads ton work with , one worker
        ex.execute(()-> System.out.println("A"));
        ex.execute(()-> System.out.println("B"));
        ex.execute(()-> System.out.println("C"));
        // always in sequence as its only one thread working in queue for executing tasks , as one thread works at a time

        ex.execute(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("D");
        });
        ex.execute(()-> System.out.println("E"));
        // still D will print before E  ,and E will have to wait as It's still one thread

    }
}
