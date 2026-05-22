import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Next_greater_Element_leetcoe_o_n_soln {

    int stack_update(int a, Stack<Integer> st) {
        while (!st.isEmpty() && st.peek() <= a) {
            st.pop();
        }
        int next_greater = !st.isEmpty() ? st.peek() : -1;
        st.push(a);
        return next_greater;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            map.put(nums2[i], stack_update(nums2[i], st));
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the first array  array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the first array ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the length of the second array ");
        int[] arr1 = new int[sc.nextInt()];
        System.out.println("enter the elements if the second array ");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        Next_greater_Element_leetcoe_o_n_soln nxt_greater = new Next_greater_Element_leetcoe_o_n_soln();
        System.out.println(Arrays.toString(nxt_greater.nextGreaterElement(arr, arr1)));
    }

}
