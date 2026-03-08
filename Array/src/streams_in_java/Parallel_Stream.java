package streams_in_java;

import java.lang.foreign.Arena;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parallel_Stream {
    public static void main(String[] args) {
        // A type of stream that enables parallel processing of elements
// Allowing multiple threads to process parts of the stream simultaneously
// This can significantly improve performance for large data sets
// workload is distributed across multiple threads

        List<Integer> list= Stream.iterate(1, x->x+1).limit(20000).toList();
        //practice
//        List<Integer> factorials = list.stream().map(x->{
//            int fact =1;
//            while(x>=1)fact*=x;
//            return fact;
//        }
//        ).toList();
//
//        Optional<Integer> fact=list.stream().reduce((a, b)->a*b);
//        System.out.println(fact.get());
        long start_time1= System.currentTimeMillis();
        List<Integer> list1 = list.stream().map(Parallel_Stream::factorial).toList();
        long end_time1 = System.currentTimeMillis();
        System.out.println("large calculations without parallel stream "+(end_time1-start_time1));
        long start_time= System.currentTimeMillis();
         list1 = list.parallelStream().map(Parallel_Stream::factorial).toList();
        long end_time = System.currentTimeMillis();
        System.out.println("large calculations with parallel stream "+(end_time-start_time));

        // parallel streams must be used in a way that the processes are not interdependent on each other

        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> list2 = Arrays.asList(1,2,3,4,5);
        List<Integer> list3 = list2.parallelStream().map(sum::addAndGet).toList();
        // expected [1,3,6,10,15]
        System.out.println(list3);
        // wrong answer because each process depends on sum which is off other process 


    }
   static int factorial(int n ){
        int f=1;
        while(n>=1){
            f*=n;
            n--;
        }
        return f;
    }
}
