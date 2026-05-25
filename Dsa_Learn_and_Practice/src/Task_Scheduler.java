import java.util.*;
import java.util.stream.Collectors;

public class Task_Scheduler {
    static public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char x : tasks) freq.put(x, freq.containsKey(x) ? freq.get(x) + 1 : 1);
        LinkedHashSet<Character> chars = freq.keySet().stream().sorted((a, b) -> freq.get(b) - freq.get(a)).collect(Collectors.toCollection(LinkedHashSet::new));
        int ans = 0;
        int count = n + 1;
        while (!chars.isEmpty()) {
            List<Character> dead_chars = new ArrayList<>();
            for (char x : chars) {
                if (count == 0) {
                    break;
                }
                System.out.print(x + " ");
                count--;
                freq.put(x, freq.get(x) - 1);
                if (freq.get(x) == 0) dead_chars.add(x);
                ans++;
            }

            for (char x : dead_chars) {
                chars.remove(x);
                freq.remove(x);
            }

            if (count > 0 && !chars.isEmpty()) {
                ans += count;
                for (int j = count; j > 0; j--) System.out.print(" idle ");
            }
            count = n + 1;
            chars = freq.keySet().stream().sorted((a, b) -> freq.get(b) - freq.get(a)).collect(Collectors.toCollection(LinkedHashSet::new));


        }

        return ans;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        char[] tasks = new char[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = sc.next().charAt(0);
        }
        System.out.println("enter limit n ");
        int n = sc.nextInt();
        System.out.println("\n" + leastInterval(tasks, n));
    }

}
