import java.util.*;
public class StringsRotationOfEachOther {
    public static boolean areRotations(String s1, String s2) {
        // Your code here
        if(s1.length()!=s2.length())return false;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(0)){
                int k=i+1;int j=1;
                for(;j<s2.length();j++,k++){
                    if(k==s1.length())k=0;
                    if(s1.charAt(k)!=s2.charAt(j))break;
                }
                if(j==s2.length())return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first String ");
        String s1 = sc.nextLine();
        System.out.println("Enter the second String ");
        String s2 = sc.nextLine();
        System.out.println(areRotations(s1,s2));
    }
}
