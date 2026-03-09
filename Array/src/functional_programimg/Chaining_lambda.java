package functional_programimg;

import java.util.function.UnaryOperator;

public class Chaining_lambda {

    public static UnaryOperator<Integer> wrapped(UnaryOperator<Integer> operator, int n) {
        return n == 0 ? x -> {
            System.out.println(" Step " + (n + 1) + "->" + n);
            return operator.apply(x);
        } : wrapped(x -> {
            System.out.println(" Step " + (n + 1) + "->" + n);
            return operator.apply(x);
        }, n - 1);

    }

    public static void main(String[] args) {

        UnaryOperator<Integer> operator = wrapped(x -> x, 10);
        operator.apply(10);
    }
}
