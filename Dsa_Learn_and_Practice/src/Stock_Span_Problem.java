import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Stock_Span_Problem {
    static int update_stack(int a, Stack<Integer> st, int[] arr, ArrayList<Integer> ans) {
        int count = 1;
        while (!st.isEmpty() && a >= arr[st.peek()]) {
            count += ans.get(st.peek());
            st.pop();
        }
        return count;
    }

    static public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ans.add(update_stack(arr[i], st, arr, ans));
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(calculateSpan(arr));
    }
}
