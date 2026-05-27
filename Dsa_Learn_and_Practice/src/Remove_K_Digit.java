import java.util.Scanner;
import java.util.Stack;

public class Remove_K_Digit {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        if (k == num.length()) return "0";
        for (int i = 0; i < num.length(); i++) {
            if(st.size()==1&&st.peek()=='0')st.pop();
            if (st.isEmpty() || k == 0) {
                    st.push(num.charAt(i));
                continue;
            }
            if (num.charAt(i) < st.peek()) {

                while (!st.isEmpty()&&num.charAt(i) < st.peek() && k > 0){
                    st.pop();
                k--;
            }
                    st.push(num.charAt(i));

            }
            else st.push(num.charAt(i));
        }
        if(st.size()==1&&st.peek()=='0')st.pop();
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();
        if(k>ans.length())return "0";
        if(k>0){
            ans = new StringBuilder(ans.substring(0, ans.length() - k));
        }

        return (ans.isEmpty()) ?"0": ans.toString();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number ");
        String num = sc.next();
        System.out.println("enter the k elements that can be removed ");
        int k = sc.nextInt();
        Remove_K_Digit removeKDigit = new Remove_K_Digit();
        System.out.println(removeKDigit.removeKdigits(num, k));
    }
}
