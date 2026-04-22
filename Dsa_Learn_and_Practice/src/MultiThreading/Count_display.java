package MultiThreading;

// for understanding that different threads
// can use the same object but method calls using local variable in each thread will be independent
public class Count_display {
    int i = 0;

    void display() {
        for (; i < 15; i++)
            System.out.println(i + " ");
    }

    public static void main(String[] args) {
        Count_display c1 = new Count_display();
        Thread t1 = new Thread(c1::display);
        Thread t2 = new Thread(c1::display);
        t1.start();
        t2.start();
    }
}
