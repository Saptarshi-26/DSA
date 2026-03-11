import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Longest_Common_Subsequence1 { // solution see

    static int lcss(String s , String s1, int i , int j ,int[][]dp){
        if(i==s.length()||j==s1.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==s1.charAt(j)){
            dp[i][j]=1+lcss(s,s1,i+1,j+1,dp);
            return dp[i][j];
        }
        int ans = Math.max(lcss(s,s1,i,j+1,dp),lcss(s,s1,i+1,j,dp));
        dp[i][j]=ans;
        return ans;
    }
    static int lcs(String s , String s1) {
        // code here
        int dp[][] = new int[s.length()][s1.length()];
        for( int [] x : dp) Arrays.fill(x,-1);
        return lcss(s,s1,0,0,dp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st String ");
        String s = sc.nextLine();
        System.out.println("Enter 2nd String ");
        String s1 = sc.nextLine();
        System.out.println(lcs(s,s1));
    }
}
