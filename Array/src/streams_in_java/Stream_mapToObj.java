package streams_in_java;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream_mapToObj {
    public static void main(String[] args) {
        //ex-1
        IntStream.rangeClosed(1,3).map(x->x*10).forEach(System.out::println);

        //ex-2
        System.out.println(IntStream.rangeClosed(1,4).boxed().toList());
        // ex -3 // even

        IntStream.rangeClosed(1,8).filter(x->x%2==0).boxed().toList().forEach(System.out::println);

        // without filter

        IntStream.rangeClosed(1,4).map(x->x*2).boxed().toList().forEach(System.out::println);

        // ex - 4

        IntStream.rangeClosed(1,4).mapToObj(x->"Value -"+x).toList().forEach(System.out::println);

        // Controlled exercise

        // level 1

        IntStream.rangeClosed(1,4).mapToObj(x->"Square-"+(x*x)).forEach(System.out::println);

        // level 2

        IntStream.rangeClosed(1,4).mapToObj(x->new Student(x)).toList();



    }
}
class Student{
    int id ;
    Student(int id){
        this.id=id;
    }
    @Override
    public String toString() {
        return "Student{id=" + id + "}";
    }
}
