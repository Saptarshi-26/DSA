package Tree;

import java.util.Arrays;
import java.util.Scanner;

public class Unique_Binary_Search_Tree {
    public int unique_tree(int n, int[] dp) {
        if (dp[n] != 0) return dp[n];
//        if (n == 3) return 5;
//        if (n == 2) return 2;
        if(n==1||n==0)return 1;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int left = unique_tree(i - 1, dp);
            int right = unique_tree(n - i, dp);
            ans+=left*right;
        }
        dp[n] = ans;
        return ans;


    }

    public int numTrees(int n) {
        if (n == 1) return 1;
        return unique_tree(n, new int[n + 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of nodes ");
        System.out.println(new Unique_Binary_Search_Tree().numTrees(sc.nextInt()));
    }
}
