import java.util.Arrays;
import java.util.Scanner;

public class Delete_Operation_for_two_String {
    public static int minD(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length() || j == s2.length()) {
            if (i == s1.length() && j == s2.length()) return 0;
            if (i == s1.length()) return s2.length() - j;
            return s1.length() - i;
        }
        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = minD(s1, s2, i + 1, j + 1, dp);
        }
        return dp[i][j] = Math.min(minD(s1, s2, i + 1, j, dp), minD(s1, s2, i, j + 1, dp)) + 1;
    }

    public static int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] x : dp)
            Arrays.fill(x, -1);
        return minD(s1, s2, 0, 0, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first string ");
        String s1 = sc.nextLine();
        System.out.println("enter the second string ");
        String s2 = sc.nextLine();
        System.out.println(minDistance(s1, s2));

    }
}
