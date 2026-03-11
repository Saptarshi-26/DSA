package functional_programimg;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Unit1Exercise_java8 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Naruto", "Uzumaki", 17),
                new Person("Sasuke", "Uchiha", 17),
                new Person("Itachi", "Uchiha", 21),
                new Person("Kakashi", "Hatake", 30),
                new Person("Hinata", "Hyuga", 16)
        );

        // step 1  sort list by last name

        people.sort((o1, o2) -> o1.getLastname().compareTo(o2.getLastname()));

        //create a method that prints all elements in the list

        printConditionally(people, p -> true);


        // create  method that prints all names that ends with u
        System.out.println("printing people whose have last name end with c ");

        printConditionally(people, p -> p.getLastname().startsWith("C"));

        System.out.println("printing people  whose last name ends with h ");

        printConditionally(people, p -> p.getLastname().startsWith("H"));

    }

    private static void printConditionally(List<Person> people, Predicate<Person> p1 ) {
        for (Person p : people) {
            if (p1.test(p))
                System.out.println(p);
        }
    }

}

