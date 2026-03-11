import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Maximum_Product_Of_three_Element_1 {
    public static long maxProduct(int[] arr) {
        long ans = 0;
        if (arr.length < 3) return ans;
        ArrayList<Integer> pos = new ArrayList<>();
        for (int x : arr) {
            if (x != 0) pos.add(Math.abs(x));
        }
        Collections.sort(pos);
        ans = ((long) pos.getLast() * pos.get(pos.size() - 2));
        return ans * (long) Math.pow(10, 5);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        System.out.println(maxProduct(arr));

    }
}
