package MultiThreading.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private final Lock lock = new ReentrantLock();

    public void outer_method(){
        lock.lock();
//        try {
//            lock.lockInterruptibly();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
        try {
            System.out.println("outer method");
            inner_method();
        }
        finally {
            lock.unlock();
        }
    }

    private void inner_method() {
        lock.lock();
        try {
            System.out.println("inner method");
            outer_method();
        }
        finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        ReentrantExample example = new ReentrantExample();
        example.outer_method();
    }

}

// no deadlock because its ReentrantLock , it can acquire lock multiple times ,
// it has a count of how many locks it acquired in a single thread ,
// so after locking for 10 times if it unlocks for once , still
// other threads cant enter as it has to unlock all 10 locks to let other threads use the lock