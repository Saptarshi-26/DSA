package MultiThreading.Producer_Consumer;

public class Consumer implements Runnable {
    Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void remove() {

        buffer.decrement();
        buffer.display();
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++)
            remove();
    }
}
