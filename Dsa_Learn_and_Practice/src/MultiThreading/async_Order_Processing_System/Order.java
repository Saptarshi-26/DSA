package MultiThreading.async_Order_Processing_System;

import java.util.concurrent.locks.ReentrantLock;

public class Order {

    ReentrantLock lock = new ReentrantLock();

    private int id;
    private int  balance = 10000;
    private int amount;
    Order(int id,int amount){
        this.id=id;
        this.amount=amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }


}
