package MultiThreading.Producer_Consumer;

public class Producer implements Runnable {
    Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void add(int item) {
        buffer.increment(item);
        buffer.display();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++)
            add(i);
    }
}
