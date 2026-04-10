package MultiThreading;

public class My_Thread_1 extends Thread{
    @Override
    public void run() {
        System.out.println("Thread is running...");
        for (int i=0;i<5;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws InterruptedException {
//        MyThread t1 = new MyThread();
//        t1.start();
//        t1.join();
//        System.out.println("hello");
//
//        My_Thread_2 t2 = new My_Thread_2("thread 1 ");  // setting priority
//                                                              // doesnt guarantee execution order
//        My_Thread_2 t3 = new My_Thread_2("thread 2 ");   // just gives a hint
//        My_Thread_2 t4 = new My_Thread_2("thread 3 ");
//        t2.setPriority(Thread.MIN_PRIORITY);
//        t3.setPriority(Thread.NORM_PRIORITY);
//        t4.setPriority(Thread.MAX_PRIORITY);
//        t4.start();
//        t3.start();
//        t2.start();
//        // start sleep join setPriority
        // yield -> lets other process get a change , its a hint like setPriority
        // daemon threads -> background threads

        My_Thread_3 t1 = new My_Thread_3("thread 1");
        t1.start();
        t1.interrupt();


    }
}
