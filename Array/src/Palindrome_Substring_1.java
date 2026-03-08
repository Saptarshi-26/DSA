import java.util.*;
public class Palindrome_Substring {
    public static boolean helper(String s , int i , int j, int[][]dp){
        if(i==j)return false;
        while(i<j){
            if(dp[i][j]!=-1){
                return dp[i][j] == 1;
            }
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    public static int cps(String s , int i , int j , int[][]dp){
        if(i>=j)return 0;
        if(dp[i][j]!=-1)return 0;
        int c=0;
        if(helper(s,i,j,dp)){
            c++;
            dp[i][j]=1;
        }
        else dp[i][j]=0;
        c+=cps(s,i+1,j,dp)+cps(s,i,j-1,dp);

        return c;
    }
    public static int countPS(String s) {
        // code here
        int [][] dp = new int[s.length()][s.length()];
        for (int [] x : dp) Arrays.fill(x,-1);
        return cps(s,0,s.length()-1,dp)+s.length();

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String ");
        String s = sc.nextLine();
        System.out.println(countPS(s));
    }
}
