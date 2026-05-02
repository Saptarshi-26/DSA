package MultiThreading.banking_excersice;

import java.util.concurrent.TimeUnit;

public class Transfer_1 {
    boolean transfer(Account from, Account to, int amount) {

        while(true) {
            try {
                if (from.lock.tryLock(1000, TimeUnit.MILLISECONDS)) {

                    if (to.lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                        break;
                    } else {
                        from.lock.unlock();
                    }
                    Thread.sleep(50);
                }
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt(); }
        }

                    try{

                    if (from.balance >= amount) {
                        from.balance -= amount;
                        to.balance += amount;

                        System.out.println("transfer successful from " + from.id + " to " + to.id);
                        System.out.println(from.id + " current balance =" + from.balance);
                        System.out.println(to.id + " current balance =" + to.balance);
                        return true;
                    } else {
                        System.out.println("Insufficient balance ");
                        return false;
                    }
                }
                finally {
                    from.lock.unlock();
                    to.lock.unlock();
                }
                }

        }

