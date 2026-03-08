package streams_in_java;

import Tree.Construct_Tree_From_Inroder_and_Preorder;

import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Basics {
    public void main(String[] args) {

       // Predicate -> functional interface which return boolean , takes one argument


//        Predicate<Integer> is_even = x->x%2==0;
//        Predicate<String > starts_with_A = x->x.toUpperCase().startsWith("A");
//        Predicate<String > starts_with_T = x-> x.toUpperCase().startsWith("T");
//        System.out.println(is_even.test(12));
//        System.out.println(starts_with_A.test("Apple"));
//        System.out.println(starts_with_A.and(starts_with_T).test("Timothy"));


        // Function -> takes input and output arguments and return the output after desired implementation

//        Function<Integer,Integer> doubleIt = x->x*2;
//        Function<Integer, Integer> tripleIt = x->x*3;
//        System.out.println(doubleIt.apply(12));
//        System.out.println(tripleIt.andThen(doubleIt).apply(12));//same
//        System.out.println(tripleIt.compose(doubleIt).apply(12));//same
//        Function<Integer,Integer> identity = Function.identity();// identity is a static method ,
//        // return same value as passed
//        System.out.println(identity.apply(12));


//        Consumer -> takes input argument but does not return anything


//        Consumer<Integer> consumer = x-> System.out.println(x*2);
//        consumer.accept(12);
//        List<Integer> list = new ArrayList<>(List.of(1,2,3,4));
//        Consumer<List<Integer>> display_list = x -> System.out.println(list);
//        display_list.accept(list);


//        Suplier -> takes nothing as input parameter , only gives output
//
//        Supplier<String> supplier = ()->"hello world ";
//        System.out.println(supplier.get());


//        Mix of all
//
//        Predicate<Integer> predicate = a-> a%2==0;
//       Function<Integer,Integer> function = a->a*a;
//        Consumer<Integer> consumer = System.out::println;
//        Supplier<Integer> supplier = ()->100;
//
//        if(predicate.test(supplier.get())){
//            consumer.accept(function.apply(supplier.get()));
//        }

        // BiPredicate , Bi =Consumer , BiFunction -> takes two arguments

//        BiPredicate<Integer,Integer> predicate = (a,b)-> (a+b)%2==0;
//        System.out.println(predicate.test(2,8));
//        BiConsumer<Integer,Integer> consumer = (a,b)-> System.out.println(a+" "+b);
//        consumer.accept(12,34);
//        BiFunction<String ,String ,Integer> function =(a,b)-> a.length()+b.length();
//        System.out.println(function.apply("saptarshi","naruto"));

//
//      UnaryOperator if input and output of a function is same we don't have to repeat

//        UnaryOperator <Integer> unaryOperator = (a)-> a*2;
//        System.out.println(unaryOperator.apply(12));
//        BinaryOperator<Integer> binaryOperator=(a,b)->a*b;
//        System.out.println(binaryOperator.apply(12,12));

//        Method reference -->  use methods wothout invoking them & in place of lambda expression

         List<String> list = Arrays.asList("Naruto ", "Hinata ", "Hagoromo ");
         list.forEach(x-> System.out.println(x));
         list.forEach(System.out::println);

//        Construct reference
//
//         List<String>  names = Arrays.asList("A","B","C");
//         List<MobilePhone> mobilePhones= names.stream().map(MobilePhone::new).collect(Collectors.toUnmodifiableList());



    }
    class MobilePhone{
        String name;

        public MobilePhone(String name) {
            this.name = name;
        }
    }
}
