package MultiThreading;

public class Test {
    public static void main(String[] args) {
//        World_extending_thread_class world = new World_extending_thread_class();
//        world.setName("world thread");
//        world.start();
//
//        World_implementing_Runnable_interface world1 = new World_implementing_Runnable_interface();
//        Thread t1 = new Thread(world1); // new state , thread is just created
//        t1.start();                     // runnable state , it started
//
//        Thread.currentThread().setName("main thread ");
//        for (;;){
//            System.out.println(Thread.currentThread().getName());
//        }
//       // System.out.println(Thread.currentThread().getName());
        Counter counter = new Counter();  // -> common object share
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (Exception e ){

        }

        System.out.println(counter.getter());

    }
}
