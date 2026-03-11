import java.util.*;

public class Range_minimum_query {

    public static int RMQ(int[] st, int n, int l, int r) {
        // Add you return 0;
        if (l == r) return st[l];
        int mid = (l + r) / 2;
        return Math.min(RMQ(st, n, l, mid == l ? mid : mid - 1), Math.min(st[mid], RMQ(st, n, mid == r ? mid : mid + 1, r)));


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of elements ");
        int[] st = new int[sc.nextInt()];
        System.out.println("enter the elements ");
        for (int i = 0; i < st.length; i++)
            st[i] = sc.nextInt();
        System.out.println("enter the lower range ");
        int l = sc.nextInt();
        System.out.println("enter the upper range ");
        int r = sc.nextInt();
        System.out.println(RMQ(st, st.length, l, r));

    }
}
