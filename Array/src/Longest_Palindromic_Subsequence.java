import java.util.*;
public class Longest_Palindromic_Subsequence {

   static int lps(String s , int i , int j , int[][]dp) {
       if(dp[i][j]!=-1)return dp[i][j];
       if(i>j){
           return 0;
       }
        if (i == j)return 1;
        int max=0;
        max=lps(s,i+1,j-1, dp);
        if(s.charAt(i)==s.charAt(j)){
            max+=2;
        }
        else
            max=Math.max(Math.max(lps(s,i,j-1,dp),lps(s,i+1,j,dp)),max);
        dp[i][j]=max;
        return max;
    }
    public static int longestPalinSubseq(String s) {
        // code here
        int[][] dp = new int[s.length()][s.length()];
        for(int [] x : dp){
            Arrays.fill(x,-1);
        }
         return lps(s,0,s.length()-1,dp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ënter the String ");
        String s = sc.nextLine();
        System.out.println(longestPalinSubseq(s));
    }
}
