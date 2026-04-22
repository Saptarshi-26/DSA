package MultiThreading.banking_excersice;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
    ReentrantLock lock = new ReentrantLock(true);
    int id;
    long balance;
    Account(){}
    Account(int id, long balance ){
        this.id=id;
        this.balance=balance;
    }
}

