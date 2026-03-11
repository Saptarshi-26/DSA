package functional_programimg;

public class Multi_Wrapped_lambda_exercise {
    static Runnable wrapped(Runnable r, int n) {
        if (n == 10) return () -> {
            System.out.print(n + " ");
            r.run();
        };
        return wrapped(() -> {
            System.out.print(n + " ");
            r.run();
        }, n + 1);
    }

    public static void main(String[] args) {

        wrapped(() -> System.out.print("END "+1), 2).run();
    }
}
