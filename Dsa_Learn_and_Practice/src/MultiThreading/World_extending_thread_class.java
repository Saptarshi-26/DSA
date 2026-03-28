package MultiThreading;

public class World_extending_thread_class extends Thread{
    @Override
    public void run() {
        for (;;)
            System.out.println(Thread.currentThread().getName());

    }
}
