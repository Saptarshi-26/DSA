import java.util.Scanner;

public class Minimum_Cost_For_Tickets {
    static public int mincost(int[] days, int[] costs, int i, int[] dp) {
        if (i >= days.length) return 0;
        if (dp[i] != 0) return dp[i];
        int min = Integer.MAX_VALUE;
        int k = i;
        int count = 1;
        for (int j = days[k] + 1; j <= days[k] + 30; j++) {

            while (i < days.length && days[i] < j) i++;
            if (count == 1) {
                min = Math.min(mincost(days, costs, i, dp) + costs[0], min);
            }
            if (count == 7) {
                min = Math.min(mincost(days, costs, i, dp) + costs[1], min);
            }
            if (count == 30) {
                min = Math.min(mincost(days, costs, i, dp) + costs[2], min);
            }
            count++;

        }

        dp[k] = min;

        return min;

    }

    static public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
        return mincost(days, costs, 0, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of days ");
        int[] days = new int[sc.nextInt()];
        System.out.println("enter the days ");
        for (int i = 0; i < days.length; i++) {
            days[i] = sc.nextInt();
        }
        int[] costs = new int[3];
        System.out.println("enter the costs for 1 , 7 , and 30 days travel ");
        //sc.nextInt();
        for (int i = 0; i < 3; i++) {
            costs[i] = sc.nextInt();
        }
        System.out.println(mincostTickets(days, costs));

    }
}
