import java.util.*;
import java.util.stream.Collectors;

public class Task_Scheduler_1 { // replaced this code with max heap in my logic by ai
    static public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> freq = new HashMap<>();

        for(char x : tasks)
            freq.put(x , freq.getOrDefault(x,0)+1);

        PriorityQueue<Character> pq =
                new PriorityQueue<>(
                        (a,b)->freq.get(b)-freq.get(a)
                );

        pq.addAll(freq.keySet());

        int ans = 0;

        int count = n+1;

        while(!pq.isEmpty()) {

            List<Character> remaining_chars = new ArrayList<>();

            while(!pq.isEmpty() && count>0) {

                char x = pq.poll();

                System.out.print(x+" ");

                freq.put(x , freq.get(x)-1);

                if(freq.get(x)>0)
                    remaining_chars.add(x);

                ans++;
                count--;
            }

            for(char x : remaining_chars)
                pq.add(x);

            if(count>0 && !pq.isEmpty()) {

                ans += count;

                for(int j=count;j>0;j--)
                    System.out.print(" idle ");
            }

            count = n+1;
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
