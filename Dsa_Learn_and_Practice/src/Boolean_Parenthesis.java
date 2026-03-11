import javax.imageio.stream.ImageInputStream;
import java.util.*;
public class Boolean_Parenthesis {
    static int check(char bool ,char exp, int [][] dp, int ind){
            if(exp=='|')return dp[ind][0];
            if(exp=='&'){
               // if()
            }
            return 0;

    }
    static  int possible_comb(String s ){
        int [][] dp = new int[s.length()][s.length()];// dp[o]-> true dp[1]-> false
        if(s.charAt(s.length()-1)=='T')
            dp[0][0]=1;
        else dp[1][0]=1;
        for(int i =s.length()-3;i>=0;i-=2){
            char exp = s.charAt(i+1);

        }
   return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string ");
        String s = sc.next();
    }
}
