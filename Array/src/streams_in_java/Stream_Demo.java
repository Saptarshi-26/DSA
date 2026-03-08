package streams_in_java;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_Demo {
    public static void main(String[] args) {
        // streams is a feature introduce in java 8
        // we can process collections of data in declarative manner
        // Simplify Data Processing
        // Embrace Functional Programming
        // Improve Readability and Maintainability
        // Enable Easy Parallelism
        // How to Use Streams ?
        // Source, intermediate operations & terminal operation

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        //numbers.stream().filter(a->a%2==0).forEach(System.out::println);
        System.out.println(numbers.stream().filter(a->a%2==0).count());

        // 1. list tp stream
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Stream<Integer> stream = list.stream();

        // 2.  from arrays
         String[] arr = {"a","b","c"};
         Stream<String> stream1 =Arrays.stream(arr);
         // 3 . using stream.of
        Stream <String> stream2 = Stream.of("a","b");

        //infinite stream
        Stream<Integer> stream3 = Stream.generate(()->1).limit(100);
        List<Integer> list1= Stream.iterate(1, a->a*2).limit(10).toList();// 1 2 4 8 16
        //System.out.println(list1);
       // stream4.forEach(System.out::println);

    }
}
