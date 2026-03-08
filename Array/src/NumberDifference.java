import java.util.*;
public class NumberDifference { // gfg weekly contest 189 1st question
    static String b(int n){
        if(n==1)return "1";
        return b(n/2)+Integer.toString(n%2);
    }
    public static int numDifference(int n) {
        // code here
        String a= b(n);
        String s = a;
        String ss="";
        for(int i=0;i<s.length();i++){
            if(ss.length()>0)
            ss+=(s.charAt(i)=='1')?"0":"1";
            else if(s.charAt(i)=='0')ss+="1";
        }
        int num=0;
        for(int i=0;i<ss.length();i++){
            if(ss.charAt(i)=='1'){
                num+=(int)Math.pow(2,(ss.length()-i)-1);
            }
        }
        return n-num;
    }
    public static void main(String[] args) {
        System.out.println(numDifference(5));
    }
}
