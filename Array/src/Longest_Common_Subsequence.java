import java.util.*;
public class Longest_Common_Subsequence {

    static  int lcss(String s , String s1, int i , int j , HashMap<String ,Integer > dp){
        String key = Integer.toString(i) + "_" + Integer.toString(j);
        if(dp.containsKey(key))return dp.get(key);
        int temp = i ;
        if(i==s.length()-1){
            if(s1.indexOf(s.charAt(i),j)>-1)return 1;
            return 0;
        }
        if(j==s1.length()-1){
            if(s.indexOf(s1.charAt(j),i)>-1)return 1;
            return 0;
        }
        while(i<s.length()&&s1.indexOf(s.charAt(i),j)<0){
            i++;
        }
        if(i>=s.length())return 0;
        int in = s1.indexOf(s.charAt(i),j);
        int ans = Math.max(lcss(s,s1,i+1,in+1,dp)+1,lcss(s,s1,i+1,j,dp));
        dp.put(Integer.toString(temp)+"_"+Integer.toString(j), ans);
        return ans;
    }
    static int lcs(String s , String s1) {
        // code here
        return lcss(s,s1,0,0,new HashMap<>());
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
