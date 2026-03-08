package functional_programimg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Self_Exercise {
    void print_even(List<Integer> list) {
        list.forEach(a -> {
            if (a % 2 == 0) System.out.println(a);
        });
    }

    void sort_length(List<String> list) {
        list.sort((a, b) -> a.length()-b.length());
        System.out.println(list);
    }

    void replace(List<String> list) {
        list.replaceAll(String::toUpperCase);
        System.out.println(list);
    }

    void operate(int a, int b, Op op) {
        try {
            System.out.println((op.operation(a, b)));
        } catch (Exception e) {
            System.out.println("invalid operation ");

        }
    }

    Op Catch_e(Op op) {
        return (i, j) -> {
            try {
                return op.operation(i, j);
            } catch (Exception e) {
                System.out.println("exception ");
                return -1;
            }
        };

    }

    void all_operation(int a, int b) {
        operate(a, b, Catch_e(Integer::sum));
        operate(a, b, Catch_e((i, j) -> i * j));
        operate(a, b, Catch_e((i, j) -> i - j));
        operate(a, b, Catch_e((i, j) -> i / j));

    }

    public static void main(String[] args) {
        Self_Exercise obj = new Self_Exercise();

        List<Integer> nums = Arrays.asList(10, 15, 20, 25, 30, 35);
        System.out.println("Even Numbers:");
        obj.print_even(nums);

        List<String> names = new ArrayList<>(Arrays.asList("Rahul", "Amit", "Saptarshi", "Sam"));
        System.out.println("\nSorted List:");
        obj.sort_length(names);

        System.out.println("\nUppercase List:");
        obj.replace(names);

        System.out.println("\nAll Operations:");
        obj.all_operation(10, 5);

        System.out.println("\nDivision by Zero Test:");
        obj.operate(10, 0, obj.Catch_e((i, j) -> i / j));
    }

    interface Op {
        int operation(int a, int b);
    }
}

