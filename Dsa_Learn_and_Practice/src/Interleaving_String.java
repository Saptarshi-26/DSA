import java.util.Scanner;
public class Interleaving_String {
    boolean interleave(String s1,String s2, String s3 ,int i , int j,int k, int[][]dp){
        if(dp[i][j]!=0)return false;
        if(k==s3.length())return true;
        boolean ans = false;

        if(i<s1.length()&&s3.charAt(k)==s1.charAt(i)){
                ans = interleave(s1,s2,s3,i+1,j,k+1,dp);
        }
         if(ans)return ans;

         if(j<s2.length()&&s3.charAt(k)==s2.charAt(j)){
             ans = interleave(s1,s2,s3,i,j+1,k+1,dp);
         }
         if(dp[i][j]==0&&!ans)dp[i][j]=1;

         return ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=(s1.length()+s2.length()))return false;
        int[][]dp = new int[s1.length()+1][s2.length()+1];
       return interleave(s1,s2,s3,0,0,0,dp);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the first String ");
        String s1 = sc.next();
        System.out.println("enter the second String ");
        String s2 = sc.next();
        System.out.println("enter the third String ");
        String s3 = sc.next();
        Interleaving_String interleavingString = new Interleaving_String();
        System.out.println(interleavingString.isInterleave(s1,s2,s3));

    }
}
