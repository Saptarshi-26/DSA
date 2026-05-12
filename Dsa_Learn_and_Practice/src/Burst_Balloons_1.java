import java.util.HashMap;
import java.util.Scanner;

public class Burst_Balloons_1 { // Tle on gfg and leetcode



    int maxCoin(int[] nums, int i , int j , int [][] dp, int left , int right ) {



        if(i>j)return 0;

        if(dp[i][j]!=0)return dp[i][j];

        if(i==j)return left*nums[i]*right;

        int ans = 0;

        for (int k=i;k<=j;k++){
            ans = Math.max(ans,Math.max(ans,maxCoin(nums,i,k-1,dp,left,nums[k]) + (left* nums[k] *right) +
                    maxCoin(nums,k+1,j,dp,nums[k],right)));
        }

        dp[i][j]=ans;


        return ans;


    }

    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        return maxCoin(nums, 0, nums.length-1, dp,1,1);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] nums = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        Burst_Balloons_1 burst_balloons = new Burst_Balloons_1();
        System.out.println(burst_balloons.maxCoins(nums));
    }
}
