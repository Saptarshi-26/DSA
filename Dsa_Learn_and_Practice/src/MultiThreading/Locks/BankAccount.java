package MultiThreading.Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        // synchronized (this) {
        System.out.println(Thread.currentThread().getName() + " attempting to " + amount);

        try {

            if (lock.tryLock(5000, TimeUnit.MILLISECONDS)) {

                try {

                    if (amount <= balance) {
                        System.out.println(Thread.currentThread().getName() + " withdrawal in progress  ");
                        Thread.sleep(10000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " withdrawal completed  ");
                    } else {
                        System.out.println(Thread.currentThread().getName() + " insuffisient balance ");
                    }


                }
                catch (InterruptedException e ){
                          Thread.currentThread().interrupt();
                }
                finally {
                    lock.unlock();
                }
            }
            else {
                System.out.println(Thread.currentThread().getName() +
                        " could not acquire the lock, will try again later");
            }



        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
// tryLock -> try to acquire the lock immediately when method is called ,
// if lock is available , it will acquire the lock else return false


// tryLock(1000,TineUnit.Millisecond) -> it will wait till 1000 millisecond if the lock is not
// available ad will acquire the lock if it's available within 1000 millisecond , else it will return false