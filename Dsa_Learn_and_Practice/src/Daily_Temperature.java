import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Daily_Temperature {
    int nextGreater(Stack<Integer> st, int[] temperature, int[] remove, int i) {
        while (!st.isEmpty() && temperature[st.peek()] <= temperature[i]) {
            remove[i] += remove[st.peek()] + 1;
            st.pop();
        }
        if (st.isEmpty()) return 0;
        return remove[i] + 1;
    }

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> st = new Stack<>();
        int[] remove = new int[temperatures.length];
        int[] ans = new int[temperatures.length];
        for (int i = ans.length - 1; i >= 0; i--) {
            int count = nextGreater(st, temperatures, remove, i);
            st.push(i);
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] temperatures = new int[sc.nextInt()];
        System.out.println("enter the temperatures ");
        for (int i = 0; i < temperatures.length; i++) {
            temperatures[i] = sc.nextInt();
        }
        Daily_Temperature dailyTemperature = new Daily_Temperature();
        Arrays.stream(dailyTemperature.dailyTemperatures(temperatures)).
                forEach(x -> System.out.print(x + " "));
    }
}
