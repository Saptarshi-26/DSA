package functional_programimg;

public class RunnableExample {
    public static void main(String[] args) {
        Thread mythread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printed inside runnable ");
            }
        });
        mythread.run();

        Thread mylamda = new Thread(() -> System.out.println("printed as lambda  "));
        mylamda.run();
    }
}
