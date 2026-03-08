package functional_programimg;

interface Process {
    void process(int i);
}

public class Closures_Example {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        doProcess(a, i -> System.out.println(i + b));

    }

    public static void doProcess(int i, Process p) {
        p.process(i);
    }
}
