package functional_programimg;

import java.util.function.BiConsumer;

public class Exception_Handling_example {
    public static void main(String[] args) {
        int[] some_numbers = {1, 2, 3, 4};
        int key = 0;
        process(some_numbers, key, (a, b) -> System.out.print(a + b + " "));
        System.out.println();
        process(some_numbers, key, (a, b) -> System.out.print(a * b + " "));
        System.out.println();
        process(some_numbers, key, wrapped((a, b) -> System.out.print(a / b + " ")));
    }

    private static void process(int[] some_numbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int i : some_numbers) {
            consumer.accept(i, key);
        }
    }

    public static BiConsumer<Integer, Integer> wrapped(BiConsumer<Integer, Integer> consumer) {
        return (a, b) -> {
            try {
                consumer.accept(a, b);
            } catch (ArithmeticException e) {
                System.out.println("exception ");
            }
        };

    }

}

