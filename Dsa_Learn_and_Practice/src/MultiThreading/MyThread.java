package MultiThreading;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Running");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread(); // new state
        System.out.println(t1.getState());

        t1.start();
        System.out.println(t1.getState());

        Thread.sleep(1000);
        System.out.println(t1.getState()); // Time waiting state -> when t1 is sleeping

        t1.join();  // this method makes the thread first finish executing
                    // before the current method resumes its execution

        System.out.println(t1.getState());  // always Terminated -> after join method ,
                                            // the current method will only execute after the join
                                            //thread is terminated


    }
}
