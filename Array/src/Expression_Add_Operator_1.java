import javax.smartcardio.ATR;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Expression_Add_Operator {

    public static List<String > add_operators(String s , int i , String exp , int sum , int target,char op){
        if(i==s.length()-1)
            return sum==target?new ArrayList<>(List.of(exp)):new ArrayList<>();
        List <String> ans =
                add_operators(s,i+1,exp+"+"+s.charAt(i+1),
                        sum+((int)s.charAt(i+1)-48),target,'+');
        ans.addAll(add_operators(s,i+1,exp+"-"+s.charAt(i+1),
                sum-((int)s.charAt(i+1)-48),target,'-'));

        if(op=='+'){
            ans.addAll(add_operators(s,i+1,exp+"*"+s.charAt(i+1),
                    (sum-((int)s.charAt(i)-48))+(((int)s.charAt(i)-48)*((int)s.charAt(i+1)-48)),target,'*'));
        } else if (op == '-') {
            ans.addAll(add_operators(s,i+1,exp+"*"+s.charAt(i+1),
                    (sum+((int)s.charAt(i)-48))-(((int)s.charAt(i)-48)*((int)s.charAt(i+1)-48)),target,'*'));
        }
        else  ans.addAll(add_operators(s,i+1,exp+"*"+s.charAt(i+1),
                    sum*((int)s.charAt(i+1)-48),target,'*'));

        return ans ;


    }
    public static List<String> addOperators(String num, int target) {
      return add_operators(num,0,""+ num.charAt(0),(int)num.charAt(0)-48,target,' ');
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string og digits ");
        String s = sc.next();
        System.out.println("enter the target ");
        int n = sc.nextInt();
        System.out.println(addOperators(s,n));

    }
}
