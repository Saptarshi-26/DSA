package streams_in_java;

import java.util.Scanner;
import java.util.function.Function;

public class Deci_to_Binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the decimal number ");
        Function<Integer, Integer>[] bin = new Function[1];
        bin[0] = x -> x == 0 ? 0 : (bin[0].apply(x / 2) * 10) + x % 2;
        System.out.println(bin[0].apply(sc.nextInt()));
    }
}
