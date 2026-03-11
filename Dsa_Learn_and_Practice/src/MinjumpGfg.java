import java.util.*;
public class MinjumpGfg {
    static int min(int[] arr , int i, int[] dp) {
        if(arr[i] == 0) return -1;  // Dead-end case
        if(i + arr[i] >= arr.length - 1) {  // Can reach or surpass the end
            return 1;
        }

        if(dp[i] != -1) {  // If already computed, return cached result
            return dp[i];
        }

        int min = -1;
        for(int j = i + 1; j <= (i + arr[i]) && j < arr.length; j++) {
            if(arr[j] == 0) continue;  // Skip dead-end jumps

            int t = min(arr, j, dp);
            if(t == -1) continue;  // No valid path from this index
            else t = t + 1;  // Add the current jump

            if(min == -1) {
                min = t;
            } else if(t < min) {
                min = t;
            }
        }

        dp[i] = min;  // Store the result in dp array
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int n= sc.nextInt();
        System.out.println("enter the elements of the array");
        int arr[]=new int[n];
        int[] dp = new int[arr.length];  // Memoization array
        Arrays.fill(dp, -1);  // Initialize with -1
        for(int i=0;i<n;i++)
            arr[i]= sc.nextInt();
        int temp=min(arr,0,dp);
        System.out.println(arr.length<=2?temp:temp);
    }
}
