package MultiThreading.Producer_Consumer;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
    private final List<Integer> list = new ArrayList<>();
    private final int limit = 10;


    public void display() {
        synchronized (this) {
            System.out.println(this.list);
        }
    }

    public void increment(int item) {
        synchronized (this) {
            while (check() >= getLimit()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            this.list.add(item);
            notifyAll();
        }
    }

    public void decrement() {
        synchronized (this) {
            while (check() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            this.list.remove(list.size() - 1);
            notifyAll();
        }
    }

    public int getLimit() {
        return limit;
    }

    public int check() {
        synchronized (this) {
            return this.list.size();
        }
    }

}
