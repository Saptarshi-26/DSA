
import java.util.*;
public class Stackreverse {
    public static void rev(Stack<Integer> s, int n) {
        if(s.size()>n) {
            int tem = s.pop();
                int tem1 = s.pop();
                s.push(tem);
                rev(s, n);
                s.push(tem1);


        }
    }
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println(" enter the size statck ");
            int n = sc.nextInt();
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < n; i++) {
                s.push(sc.nextInt());
                System.out.println(s);
            }
            for (int i = 0; i < s.size(); i++) {
               rev(s,i+1);

            }
            System.out.println(s);

        }


}


