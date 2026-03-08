import java.util.Arrays;
import java.util.Scanner;

public class Frog_jump {
    static int min_cost(int[] height, int i, int[] dp) {
        if (dp[i] != -1) return dp[i];
        if (i == height.length - 1) return 0;
        int ans = Math.abs(height[i] - height[i + 1]) + min_cost(height, i + 1, dp);
        if (i + 2 < height.length)
            ans = Math.min(Math.abs(height[i] - height[i + 2]) + min_cost(height, i + 2, dp), ans);
        dp[i] = ans;
        return dp[i];
    }

    static int minCost(int[] height) {
        // code here
        int[] dp = new int[height.length];
        Arrays.fill(dp, -1);
        return min_cost(height, 0, dp);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("e ter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        System.out.println(minCost(arr));
    }
}
