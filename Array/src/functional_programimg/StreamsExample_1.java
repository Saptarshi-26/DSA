package functional_programimg;

import java.util.Arrays;
import java.util.List;

public class StreamsExample_1 {
    public static void main(String[] args) {
        List<Person> people =
                Arrays.
                        asList(new Person("Naruto", "Uzumaki", 17),
                                new Person("Sasuke", "Uchiha", 17),
                                new Person("Itachi", "Uchiha", 21),
                                new Person("Kakashi", "Hatake", 30),
                                new Person("Hinata", "Hyuga", 16));
        
        people.parallelStream().filter(p -> p.getLastname().startsWith("U")).forEach(p -> System.out.println(p.getFirstname()));

        System.out.println(people.stream().filter(p -> p.getLastname().startsWith("U")).count());
    }
}
