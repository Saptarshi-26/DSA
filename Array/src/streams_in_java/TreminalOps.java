package streams_in_java;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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

      

    }
}
