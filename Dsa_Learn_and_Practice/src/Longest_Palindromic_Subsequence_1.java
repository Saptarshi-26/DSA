import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Longest_Palindromic_Subsequence_1 {

   static int lps(String s , int i , int j , HashMap<String ,Integer>dp) {
       String k = i+"_"+j;
       if(dp.containsKey(k))return dp.get(k);
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
        dp.put(k,max);
        return max;
    }
    public static int longestPalinSubseq(String s) {
        // code here
         return lps(s,0,s.length()-1,new HashMap<>());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ënter the String ");
        String s = sc.nextLine();
        System.out.println(longestPalinSubseq(s));
    }
}
