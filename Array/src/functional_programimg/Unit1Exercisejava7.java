package functional_programimg;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1Exercise {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Naruto", "Uzumaki", 17),
                new Person("Sasuke", "Uchiha", 17),
                new Person("Itachi", "Uchiha", 21),
                new Person("Kakashi", "Hatake", 30),
                new Person("Hinata", "Hyuga", 16)
        );

        // step 1  sort list by last name
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastname().compareTo(o2.getLastname());
            }
        });
        //create a method that prints all elements in the list
        printAll(people);


        // create  method that prints all names that ends with u
        System.out.println("printing people whose have last name end with c ");
        printLastnameBeginWith(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return p.getLastname().startsWith("U");
            }
        });
        System.out.println("printing people  whose last name ends with h ");
        printLastnameBeginWith(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return p.getLastname().startsWith("H");
            }
        });

    }

    private static void printLastnameBeginWith(List<Person> people, Condition condition) {
        for (Person p : people) {
            if(condition.test(p))
                System.out.println(p);
        }
    }

    private static void printAll(List<Person> people) {
        for (Person p : people) {
            System.out.println(p.toString());
        }
    }
}
interface  Condition {
    boolean test (Person p );
}
