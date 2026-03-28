package MultiThreading;

public class Test {
    public static void main(String[] args) {
        World_extending_thread_class world = new World_extending_thread_class();
        world.setName("world thread");
        world.start();

        World_implementing_Runnable_interface world1 = new World_implementing_Runnable_interface();
        Thread t1 = new Thread(world1);
        t1.start();

        Thread.currentThread().setName("main thread ");
        for (;;){
            System.out.println(Thread.currentThread().getName());
        }
       // System.out.println(Thread.currentThread().getName());
    }
}
