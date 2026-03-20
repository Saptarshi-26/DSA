package streams_in_java;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Peronal_Practice_Streams {
    public static void main(String[] args) {
        List<String> names = List.of("Ram", "Shyam", "Sita", "Gita");
        //ex-1
        names.stream().filter(x -> x.length() > 4).forEach(System.out::println);
        // ex-2
        List<String> list = names.stream().filter(x -> x.contains("a") || x.contains("A")).map(x -> x.toUpperCase()).toList();
        //ex-3
        String s = String.valueOf(names.stream().filter(x -> x.contains("a") || x.contains("A")).map(x -> x.toUpperCase()).reduce((a, b) -> a + "," + b));

        //ex-4
        names.stream().collect(Collectors.toSet());
        // ex - 5
        names.stream().collect(Collectors.joining(","));

        //ex-6
        Map<Integer, List<String>> map = names.stream().collect(Collectors.groupingBy(x -> x.length()));
        //ex-7
        Map<Integer, Long> map1 = names.stream().collect(Collectors.groupingBy(x -> x.length(), Collectors.counting()));
        // exe - 8
        Map<Integer, String> map3 = names.stream().collect(Collectors.groupingBy(x -> x.length(), Collectors.joining(", ")));

        // ex - 9
        Map<Integer, List<String>> map4 = names.stream().map(x -> x.toUpperCase()).collect(Collectors.groupingBy(x -> x.length()));
        // ex- 10
        Map<Integer, Long> map5 = names.stream().filter(x -> x.startsWith("S")).collect(Collectors.groupingBy(x -> x.length(), Collectors.counting()));
        //ex - 11
        Map<Integer, Integer> map6 = names.stream().collect(Collectors.groupingBy(x -> x.length(), Collectors.summingInt(x -> x.length())));

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //practice 1
        list1.stream().collect(Collectors.groupingBy(x -> x % 2 == 0 ? "even" : "odd", Collectors.counting()));
        // practice 2
        list1.stream().collect(Collectors.groupingBy(x -> x % 2 == 0 ? "even" : "odd", Collectors.summingInt(x -> x)));
        // practice 3
        names.stream().collect(Collectors.groupingBy(x -> x.charAt(0), Collectors.counting()));
        // practice 4
        names.stream().collect(Collectors.groupingBy(x -> x.length()));
        // practice 5
        list1.stream().collect(Collectors.groupingBy(x -> x > 5, Collectors.counting()));
        //practice 6
        list1.stream().collect(Collectors.groupingBy(x -> x > 5, Collectors.summingInt(x -> x)));
        // practive 7
        String s1 = "programming";
        s1.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        // practice 8
        s1.chars().mapToObj(x -> (char) x).filter(x -> s1.indexOf(x) == s1.lastIndexOf(x)).findFirst();

        //practice

        List<Integer> list2 = Arrays.asList(10, 15, 20, 25, 30);
        list2.stream().filter(x -> x > 20).toList().forEach(System.out::println);
        list2.stream().filter(x -> x % 5 == 0).map(x -> Math.pow(x, 2)).toList();
        list2.stream().filter(x -> x > 5).findFirst().get();
        List<String> names_1 = Arrays.asList("Ram", "Ravi", "Amit", "Ankit");
        names_1.stream().collect(Collectors.groupingBy(x -> x.charAt(0)));
        List<String> list3 = Arrays.asList("a", "b", "a", "c", "b", "a");
        list3.stream().collect(Collectors.groupingBy(x -> x, TreeMap::new, Collectors.counting()));

        String s2 = "swiss";
        HashMap<Character, Long> h1 = s2.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()));
        System.out.println(h1.keySet().stream().filter(x -> h1.get(x) == 1).findFirst().get());

        List<Integer> list4 = Arrays.asList(1, 1, 1, 2, 2, 3);
        int k = 2;
        HashMap<Integer, Long> h2 = list4.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        h2.keySet().stream().sorted((a, b) -> (int) (h2.get(b) - h2.get(a))).limit(k).toList().forEach(System.out::println);


    }
}
