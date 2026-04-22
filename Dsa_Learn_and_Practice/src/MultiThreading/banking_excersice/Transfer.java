package MultiThreading.banking_excersice;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Transfer {
    void transfer(Account from , Account to , int amount){

            while(true) {
                try {
                    if (from.lock.tryLock(1000, TimeUnit.MILLISECONDS)) break;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("ongoing transaction in progress");
            }
                try {

                    while(true) {
                        try {
                            if (to.lock.tryLock(1000, TimeUnit.MILLISECONDS)) break;
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        System.out.println("ongoing transaction in progress");
                    }

                        try {

                            if (from.balance >= amount) {
                                from.balance -= amount;
                                to.balance += amount;

                                System.out.println("transfer successful from "+from.id+" to "+ to.id);
                                System.out.println(from.id+" current balance ="+from.balance);
                                System.out.println(to.id+" current balance ="+to.balance);
                            } else {
                                System.out.println("Insufficient balance ");
                            }
                        } finally {
                            to.lock.unlock();
                        }
                    }

                finally {
                    from.lock.unlock();

                }
            }

            }





