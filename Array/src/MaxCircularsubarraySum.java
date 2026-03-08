import java.util.*;
public class MaxCircularsubarraySum {
    public static int circularSubarraySum(int[] arr) {

        // Your code here
        int max=-1;
        int m=0;
        int min=Integer.MAX_VALUE;
        int n=0;
        int sum=0;
        int minval=Integer.MIN_VALUE;
        for (int j : arr) {
            sum += j;
            if (j < 0) {
                if (j > minval) minval = j;
            }
            m += j;
            n += j;
            if (m < 0) m = 0;
            else if (m > max) max = m;
            if (n >= 0) n = 0;
            else if (n < min) {
                min = n;
            }
        }
        if(max==-1)return minval;
        return Math.max(max,sum-min);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println(circularSubarraySum(arr));
    }
}
