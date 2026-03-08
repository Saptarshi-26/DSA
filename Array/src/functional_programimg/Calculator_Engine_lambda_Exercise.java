package functional_programimg;

import java.util.HashMap;
import java.util.Scanner;

public class Calculator_Engine_lamda_Excercise {
    static void cal_eng(HashMap<String, op> h, String s, int a, int b) {
        if (h.containsKey(s)) System.out.println(h.get(s).operate(a, b));

    }

    static op wrapped(op o) {
        return (a, b) -> {
            try {
                return o.operate(a, b);
            } catch (Exception e) {
                System.out.println("Exception occurred ");
                return -1;
            }
        };

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the operation ");
        String s = sc.next();
        System.out.println("enter the first number ");
        int a = sc.nextInt();
        System.out.println("enter the second number ");
        int b = sc.nextInt();
        HashMap<String, op> h = new HashMap<>();
        h.put("add", wrapped(Integer::sum));
        h.put("product", wrapped((x, y) -> x * y));
        h.put("subtract ", wrapped((x, y) -> x - y));
        h.put("divide", wrapped((x, y) -> x / y));

        cal_eng(h, s, a, b);

    }
}

interface op {
    int operate(int a, int b);
}
