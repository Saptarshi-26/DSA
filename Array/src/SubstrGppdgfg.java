
import java.util.*;
public class SubstrGppdgfg { // gfg
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string ");
        String s = sc.nextLine();
        Long count = 0l;
        Long n = 0l;
        //  Long temp=0l;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int t = (int) (ch) - 48;
            if (t == 0 && i < (s.length() - 1)) n++;
            if (t % 2 != 0) {
                count += (i + 1);
                if (n > 0) count -= n;
            }
            //    count+=temp;


        }
        System.out.println(count);
    }
}