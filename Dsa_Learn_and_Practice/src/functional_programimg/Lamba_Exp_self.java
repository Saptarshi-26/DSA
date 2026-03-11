package functional_programimg;

public class Lamba_Exp_self {
    static display wrapped_2(display d) {
        return () -> {
            d.print();
            System.out.println("print 3 ");

        };
    }

    static display wrapped_1(display d) {
        return wrapped_2(() -> {
            d.print();
            System.out.println("print 2 ");
        });

    }

    public static void main(String[] args) {
        wrapped_1(() -> System.out.println("print 1")).print();
    }
}

interface display {
    void print();
}