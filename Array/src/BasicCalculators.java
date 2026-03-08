import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BasicCalculators {
    static int sum(String s , AtomicInteger a ){
        String num="0123456789";
        char op='+';
        int sum=0;
        String b ="0";
        for(int i=0;i<s.length();i++, a.set(a.get()+1)) {
            char ch = s.charAt(i);
            if(ch==' ')continue;
            if(num.indexOf(ch)>-1){
                b+=ch;
            }
            else {
                if(op=='+')sum+=Integer.parseInt(b);else sum-=Integer.parseInt(b);
                b="0";
                if(ch=='+'||ch=='-'){
                    op=ch;
                }
                else if(ch=='('){
                    AtomicInteger a1 = new AtomicInteger(1);
                    int temp=sum(s.substring(i+1),a1);
                    if(op=='+')sum+=(temp);else sum-=(temp);
                    op='+';
                    b="0";
                    i+=a1.get();
                    a.set(a.get()+a1.get());
                }
                else if(ch==')'){
                    return sum;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the equation ");
        String s = sc.nextLine();
        System.out.println(sum("("+s+")",new AtomicInteger(1)));
    }
}
