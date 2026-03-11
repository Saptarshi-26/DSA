import java.util.*;

public class Min_Cost_Climbing_Stairs {

    static int mincost(int i, int[] cost, int[] dp) {
        if (i > cost.length - 1) return 0;
        if (dp[i] != -1) return dp[i];
        dp[i] = Math.min(mincost(i + 1, cost, dp), mincost(i + 2, cost, dp)) + cost[i];
        return dp[i];
    }

    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(mincost(0, cost, dp), mincost(1, cost, dp));


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of elements ");
        int[] cost = new int[sc.nextInt()];
        System.out.println("enter the elements ");
        for (int i = 0; i < cost.length; i++) {
            cost[i] = sc.nextInt();
        }
        System.out.println(minCostClimbingStairs(cost));
    }
}
