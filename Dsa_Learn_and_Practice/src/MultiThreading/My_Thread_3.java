package MultiThreading;

public class My_Thread_3 extends Thread{
    My_Thread_3(String name){
        super(name);
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Thread running ");
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted ...");
        }
    }
    }

