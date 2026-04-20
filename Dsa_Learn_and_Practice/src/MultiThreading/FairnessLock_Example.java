package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLock_Example {
  //  private Lock lock = new ReentrantLock(); -> unfair lock
    private Lock lock = new ReentrantLock(true);  // fair lock
    public void access_resources (){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+" aquired the lock");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally {
            System.out.println(Thread.currentThread().getName()+" lock released");
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        FairnessLock_Example example = new FairnessLock_Example();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.access_resources();
            }
        };
        Thread t1 = new Thread(task,"Thread 1 ");
        Thread t2 = new Thread(task,"Thread 2 ");
        Thread t3 = new Thread(task,"Thread 3 ");

        t1.start();
//        try {
//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
        t2.start();
//        try {
//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
        t3.start();

    }

}
