import java.util.HashMap;
import java.util.Scanner;

public class Target_Sum {
    public static int sum(int[] arr, int i, HashMap<String, Integer> dp, int s, int sum) {
        if (i == arr.length) {
            return s == sum ? 1 : 0;
        }
        String key = i + "_" + s;
        if (dp.containsKey(key)) return dp.get(key);
        dp.put(key, sum(arr, i + 1, dp, s + arr[i], sum) + sum(arr, i + 1, dp, s - arr[i], sum));
        return dp.get(key);

    }

    public static int findTargetSumWays(int[] arr, int sum) {

        return sum(arr, 0, new HashMap<>(), 0, sum);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        System.out.println("enter the target ");
        int sum = sc.nextInt();
        System.out.println(findTargetSumWays(arr, sum));
    }
}
