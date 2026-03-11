import java.util.*;

public class Edit_Distance {
    public static int ed(String s, String s1, int i, int j, int[][] dp) {

        if (dp[i][j] != -1) return dp[i][j];

        if (i >= s.length() || j >= s1.length()) {
            if (i == s.length() && j == s1.length()) return 0;
            if (i >= s.length()) return s1.length() - j;
            return s.length() - i;
        }

        if (s.charAt(i) == s1.charAt(j)) {
            return ed(s, s1, i + 1, j + 1, dp);
        }

        int replace = ed(s, s1, i + 1, j + 1, dp) + 1;
        int insert = ed(s, s1, i, j + 1, dp) + 1;
        int del = ed(s, s1, i + 1, j, dp) + 1;

        int ans = Math.min(replace, Math.min(insert, del));
        dp[i][j] = ans;
        return ans;
    }

    public static int editDistance(String s1, String s2) {
        // Code here
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] x : dp) Arrays.fill(x, -1);
        return ed(s1, s2, 0, 0, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first String ");
        String s = sc.nextLine();
        System.out.println("Enter the second String ");
        String s1 = sc.nextLine();
        System.out.println(editDistance(s, s1));
    }
}
