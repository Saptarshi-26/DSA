package streams_in_java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
        //Intermediate operation transforms one stream to another streams
        // they don't execute until terminal operation is invoked

        // 1. filter
        List<String> list = Arrays.asList("Naruto", "Sakura ", "Madara", "Nagato", "Naruto");
        System.out.println(list.stream().filter(x -> x.startsWith("S")).count());

        // 2. map
        System.out.println(list.stream().map(String::toUpperCase).toList());

        // 3. sorted
        System.out.println(list.stream().sorted().toList());
        System.out.println(list.stream().sorted((a, b) -> a.length() - b.length()).toList());

        // 4. distinct

        System.out.println(list.stream().filter(x -> x.startsWith("N")).distinct().toList());

        //  5. limit

        System.out.println(Stream.iterate(1, x -> x + 1).limit(100).toList());

        // 6. skip

        System.out.println(Stream.iterate(1, x -> x + 1).skip(15).limit(100).toList());

        
    }
}
