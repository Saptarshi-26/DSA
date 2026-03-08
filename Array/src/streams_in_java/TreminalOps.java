package streams_in_java;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreminalOps {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,8,9,12);

        //  collect

        list.stream().skip(1).collect(Collectors.toSet());
        list.stream().skip(3).toList();

        //for each
        list.stream().forEach(System.out::println);

        //reduce : combines elements to produce a singe result
        Optional<Integer> reduce = list.stream().reduce(Integer::sum);
        System.out.println(reduce.get());

        // anyMatch, allMatch , noneMatch  -> short circuit method , find one match , stop executing

        System.out.println(list.stream().anyMatch(x->x%2==0));
        System.out.println(list.stream().allMatch(x->x%2==0));
        System.out.println(list.stream().noneMatch(x->x%2==0));

        // findFist , findAny  -> short circuit method

        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        List<String> list1 = Arrays.asList("Naruto","Sakura ", "Rin","Guy","Lee");

        //to print names wiht name of kength 3
        System.out.println(list1.stream().filter(x-> x.length()==3).toList());

        // squaring and sorting numbers

        List<Integer> list2 = Arrays.asList(1,4,2,5,3,8);
        System.out.println(list2.stream().map(x->(int)Math.pow(x,2)).toList());
        System.out.println(list2.stream().sorted((a,b)->b-a).toList());

        // summing values
        System.out.println(list2.stream().reduce(Integer::sum).get());
        list1.forEach(x->System.out.println( x.chars().filter(ch->ch=='a')));

        // map all string with exactly one a

        System.out.println(list1.stream().filter(x->x.chars().filter(ch->ch=='a').count()==1 ).toList());

        // 7. peek
        // performs on action on each element as it is consumed
        Stream.iterate(1, x->x+1).limit(100).peek(System.out::println);

        // 8. toArray
        Object [] arr = Stream.iterate(1,x->x+1).limit(10).toArray();

        // 9. max/min
        System.out.println(Stream.iterate(1,x->x%2==0?x+1:x+1+(x%2)).limit(10).max(Comparator.naturalOrder()).get());

        // 10. flatMap
        // Handle streams of collections, lists, or arrays where each element is itself a collection
        // Flatten nested structures (e.g., lists within lists) so that they can be processed as a single sequence of elements
        // transforms and flatten elements at the same time ( nested list to single line)

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")
        );

        System.out.println(listOfLists.stream().flatMap(x->x.stream()).toList());
        List<String> sentences = Arrays.asList(
                "Hello world",
                "Java streams are powerful",
                "flatMap is useful"
        );
        System.out.println(sentences.stream().flatMap(x->Arrays.stream(x.split(" "))).toList());



        //Stream cannot be reused after it is used after terminal operations has been used once

        Stream<String> stream = list1.stream();
        stream.forEach(System.out::println);
        System.out.println(stream.map(x->x.toLowerCase()).toList()); // exception

        // stateless and stateful


    }
}
