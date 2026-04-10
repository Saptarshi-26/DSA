package MultiThreading;

public class My_Thread_2 extends Thread {
    My_Thread_2(String name){
       super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " -Priority :" + Thread.currentThread().getPriority() + " count :" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
