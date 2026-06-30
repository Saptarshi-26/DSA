import java.util.Arrays;
import java.util.Scanner;

public class Partition_Array_For_maximum_Sum {
    public int maxSum(int[] arr, int k, int i, int[] dp) {
        if (dp[i] != 0) return dp[i];
        if(i >= arr.length) return 0;
        int max = 0;
        int max_sum =0;
        int ans = 0;
        int j =i;
        for (;j<arr.length && j<i+k;j++){
            max=Math.max(max,arr[j]);
            max_sum=Math.max(max_sum,max*(j-i+1));
            ans = Math.max(ans,max_sum+maxSum(arr,k,j+1,dp));
        }
        dp[i]=ans;
        return ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];
        return maxSum(arr, k, 0, dp);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of thw array ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the no of partitions ");
        int k = sc.nextInt();
        Partition_Array_For_maximum_Sum sum = new Partition_Array_For_maximum_Sum();
        System.out.println(sum.maxSumAfterPartitioning(arr, k));

    }
}
