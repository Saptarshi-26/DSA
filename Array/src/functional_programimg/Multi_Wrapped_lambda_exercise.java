package functional_programimg;

import java.util.concurrent.atomic.AtomicInteger;

public class Multi_Wrapped_lambda_exercise {
    static Runnable wrapped_1(Runnable r, int n) {
        AtomicInteger a = new AtomicInteger(n);
        if (n == 10) return () -> {
            System.out.print(a.get() + " ");
            r.run();
        };
        return wrapped_1(() -> {
            System.out.print(a.get() + " ");
            r.run();
        }, n + 1);
    }

    public static void main(String[] args) {
        wrapped_1(() -> System.out.print(1), 1).run();
    }
}
