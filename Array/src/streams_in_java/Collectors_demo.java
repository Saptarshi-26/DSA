package streams_in_java;

import ooP.Interfaces.Animals.Liger;

import java.util.*;
import java.util.stream.Collectors;

public class Collectors_demo {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        IntSummaryStatistics stats = num.stream().collect(Collectors.summarizingInt(x->x));
//        System.out.println(stats.getMax());
//        System.out.println(stats.getAverage());
//        System.out.println(stats.getCount());
       // .... many more functions

        System.out.println(num.stream().collect(Collectors.averagingDouble(x->x)));

       Map<String ,Integer> map =  num.stream().collect(Collectors.groupingBy(x->x%2==0?"even":"odd", Collectors.summingInt(x->x)));
        System.out.println(map.get("even"));
        System.out.println(map.get("odd"));
        TreeMap<String ,Long> map1 = num.stream().collect(Collectors.groupingBy(x->x.toString(),TreeMap::new,Collectors.counting()));

        // partitioning
        System.out.println(num.stream().collect(Collectors.partitioningBy(x->x%2==0)));


        String sentence ="hi i am Saptarshi Saha, hi i am naruto Saha";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x->x,Collectors.counting())));
        String s ="ojnaounfowjnfwjfb";
        System.out.println(s.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(x->x,Collectors.counting())));

        // summing value of map

        System.out.println(map.values().stream().reduce(Integer::sum).get());

    }
}
