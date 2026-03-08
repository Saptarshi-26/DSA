import java.util.*;

public class Coin_Change_Minimum_Coins {
    public static int minCoins(int[] coins, int sum, int s, int j, int[][] dp) {
        // code here

        if (s == sum) return 0;
        if (s > sum) return Integer.MAX_VALUE;
        if (dp[s][j] != -1) return dp[s][j];
        int min = Integer.MAX_VALUE;
        for (int i = j; i < coins.length; i++) {
            if (coins[i] > sum) continue;
            min = Math.min(minCoins(coins, sum, s + coins[i], i, dp), min);
        }
        if (min == Integer.MAX_VALUE) {
            dp[s][j] = min;
            return min;
        }
        dp[s][j] = min + 1;
        return min + 1;

    }

    public static int minCoins(int[] coins, int sum) {
        // code here
        int[][] dp = new int[sum][coins.length];
        for (int[] x : dp) Arrays.fill(x, -1);
        int ans = minCoins(coins, sum, 0, 0, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements if the array ");
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
        System.out.println("enter the target sum ");
        int sum = sc.nextInt();
        System.out.println(minCoins(arr, sum));

    }
}
