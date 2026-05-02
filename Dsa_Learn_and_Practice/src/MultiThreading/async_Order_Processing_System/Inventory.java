package MultiThreading.async_Order_Processing_System;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Inventory {

    Lock lock = new ReentrantLock(true);

    private long stock = 1000000;

   private boolean check_stock(int amount) {
        return this.stock -amount> 0;
    }

    boolean reduce_stock(int amount) {

        while (true) {
            try {
                if (this.lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                    break;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }

        try {
            if (check_stock(amount)) {
                this.stock -= amount;
                System.out.println(this.stock);
                return true;
            } else return false;
        } finally {
            this.lock.unlock();
        }


    }


}

