import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Minimum_Sum_Partition {
    public static int minDifference(int[] arr) {
        // Your code goes here
        int sum = 0;
        for (int x : arr) sum += x;
        HashSet<Integer> h = new HashSet<>(Set.of(arr[arr.length - 1]));
        int min = Math.abs((sum - arr[arr.length - 1]) - arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            HashSet<Integer> temp = new HashSet<>();
            for (int x : h) {
                temp.add(arr[i] + x);
                min = Math.min(min, Math.abs((sum - (arr[i] + x)) - (arr[i] + x)));
            }
            h.add(arr[i]);
            h.addAll(temp);
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        System.out.println(minDifference(arr));
    }
}
