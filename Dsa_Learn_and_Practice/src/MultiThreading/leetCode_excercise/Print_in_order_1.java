package MultiThreading.leetCode_excercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
class Foo {
    AtomicInteger count = new AtomicInteger(0);
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.

        printFirst.run();
        count.set(count.get()+1);
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(count.get()<1);
        printSecond.run();
        count.set(count.get()+1);
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(count.get()<2);
        printThird.run();
    }
}

public class Print_in_order_1 {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(3);
        Foo_1 f = new Foo_1();
        ex.execute(()-> {
            try {
                f.first(()-> System.out.println("first"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        ex.execute(()-> {
            try {
                f.second(()-> System.out.println("second"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        ex.execute(()-> {
            try {
                f.third(()-> System.out.println("third"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
