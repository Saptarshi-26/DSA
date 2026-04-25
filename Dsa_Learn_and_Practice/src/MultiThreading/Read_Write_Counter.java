package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Read_Write_Counter {
    private int count = 0;

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private Lock readlock = lock.readLock();
    private Lock writelock = lock.writeLock();

    public void increament(){
        writelock.lock();
//        try {
//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
        try {
            count++;
        }
        finally {
            writelock.unlock();
        }
    }

    public  int getCount(){
        readlock.lock();  // multiple threads can acquire this lock ,
                          // but only if no writer lock is not locked

        try {
            return count;
        }
        finally {
            readlock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Read_Write_Counter counter = new Read_Write_Counter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+" read : "+ counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    counter.increament();
                    System.out.println(Thread.currentThread().getName()+"  increamented ");
                }
            }
        };
        
        Thread writeThread = new Thread(writeTask);
        Thread readThread = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);

        writeThread.start();
        readThread.start();
        readThread2.start();

        writeThread.join();
        readThread.join();
        readThread2.join();

    }



}
