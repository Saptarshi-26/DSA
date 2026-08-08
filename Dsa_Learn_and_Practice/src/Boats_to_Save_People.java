import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Boats_to_Save_People {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int i = 0;
        int j = people.length - 1;
        while (i <= j && count < people.length) {
            if (people[i] + people[j] > limit) {
                j--;
                count++;
            } else {
                count++;
                i++;
                j--;

            }
        }
        return count;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of people");
        int[] people = new int[sc.nextInt()];
        System.out.println("enter people");
        IntStream.range(0, people.length).forEach(i -> people[i] = sc.nextInt());
        System.out.println("enter the limit");
        int limit = sc.nextInt();
        System.out.println(new Boats_to_Save_People().numRescueBoats(people, limit));
    }
}
