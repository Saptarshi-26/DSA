import java.util.Arrays;
import java.util.Scanner;

public class Maximum_Length_of_Repeated_Subarray {
    public int helper(int[] nums1, int[] nums2, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) return dp[i][j];
        if (i >= nums1.length || j >= nums2.length || nums1[i] != nums2[j]) return 0;
        dp[i][j] = helper(nums1, nums2, i + 1, j + 1, dp) + 1;
        return dp[i][j];
    }

    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    max = Math.max(max, helper(nums1, nums2, i, j, dp));
                }
            }
        }
        return max;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of elements in the first array ");
        int[] nums1 = new int[sc.nextInt()];
        System.out.println("enter the elements of the first array ");
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = sc.nextInt();
        }
        System.out.println("enter the no of  elements of the second array ");
        int[] nums2 = new int[sc.nextInt()];
        System.out.println("enter the elements of the second array ");
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = sc.nextInt();
        }
        System.out.println(new Maximum_Length_of_Repeated_Subarray().findLength(nums1, nums2));
    }
}
