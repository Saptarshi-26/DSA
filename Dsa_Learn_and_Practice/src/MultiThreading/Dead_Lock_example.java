package MultiThreading;
class Pen{
public synchronized void writeWithPenAndPaper(Paper paper) {
    System.out.println(Thread.currentThread().getName() + " locked Pen and trying to lock Paper");

    try {
        Thread.sleep(100);
    } catch (Exception e) {
    }

    paper.finishWriting();
}

public synchronized void finishWriting() {
    System.out.println(Thread.currentThread().getName() + " finished using Pen");
}
}

class Paper {

    public synchronized void writeWithPaperAndPen(Pen pen) {
        System.out.println(Thread.currentThread().getName() + " locked Paper and trying to lock Pen");

        try {
            Thread.sleep(100);
        } catch (Exception e) {
        }

        pen.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using Paper");
    }
}


// Task 1
class Task1 implements Runnable {

    private Pen pen;
    private Paper paper;

    public Task1(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper);
    }
}


// Task 2
class Task2 implements Runnable {

    private Pen pen;
    private Paper paper;

    public Task2(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        synchronized (pen) { // this will prevent deadlock as paper will only start
            // executing when pen lock is released so while trying to acquire pens lock it doesn't have to wait and fall in deadlock

            //synchronized (paper) {
                paper.writeWithPaperAndPen(pen);
           // }
        }
    }
}

public class Dead_Lock_example {
    public static void main(String[] args) {

        Pen pen = new Pen();
        Paper paper = new Paper();

        Task1 task1 = new Task1(pen, paper);
        Task2 task2 = new Task2(pen, paper);

        Thread t1 = new Thread(task1, "Thread-1");
        Thread t2 = new Thread(task2, "Thread-2");

        t1.start();
        t2.start();
    }
}
