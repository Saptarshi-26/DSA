import java.util.*;
public class MakeRepeattomakeSubstring {
    static int minRepeats(String s1, String s2) {
        // code here
        StringBuilder ss = new StringBuilder();
        ss.append(s1);
        int c=1;
        while(ss.length()<=Math.max(s1.length(),s2.length())*3){
            if(ss.toString().contains(s2))return c;
            ss.append(s1);
            c++;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter s1 String ");
        String s1 = sc .next();
        System.out.println("Enter the s2 String ");
        String s2 = sc.next();
        System.out.println(minRepeats(s1,s2));
    }
}
