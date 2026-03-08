import java.util.*;// time limit exceeded

public class Coin_Change {
    public static int count(int[] coins, int sum, int s, int j, int[][] dp) {
        // code here.
        if (s == sum) return 1;
        else if (s > sum) return 0;
        int count = 0;
        for (int i = j; i < coins.length; i++) {
            dp[s][i] = dp[s][i] == -1 ? count(coins, sum, s + coins[i], i, dp) : dp[s][i];
            count += dp[s][i];
        }
        return count;
    }

    public static int count(int[] coins, int sum) {
        // code here.
        int[][] dp = new int[sum][coins.length + 1];
        for (int[] x : dp)
            Arrays.fill(x, -1);
        Arrays.sort(coins);
        return count(coins, sum, 0, 0, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the  elements of the array ");
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
        System.out.println("enter the target sum ");
        int sum = sc.nextInt();
        System.out.println(count(arr, sum));
    }
}
