package MultiThreading;

public class World_implementing_Runnable_interface implements Runnable{
    @Override
    public void run() {
        for (;;)
            System.out.println(Thread.currentThread().getName());
    }
}
