import java.util.*;
public class Infix_to_postfix {
    static String add(Stack<Character> st ){
        StringBuilder ans = new StringBuilder();
        while(st.peek()!='('){
            ans.append(st.pop());
        }
        st.pop();
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expression ");
        String s = sc.next().toUpperCase();
        String p = " +- */ ^ ";
        Stack<Character> st = new Stack<>();
        StringBuilder ans= new StringBuilder();
        int i=0;
        while(i<s.length()){
               if((s.charAt(i)>='A'&&s.charAt(i)<='Z')||
                       (s.charAt(i)>='a'&&s.charAt(i)<='z')||
                       (s.charAt(i)>='0'&&s.charAt(i)<='9'))
               {
                   ans.append(s.charAt(i));
                   i++;
                   continue;
               }
               if(s.charAt(i)=='('){
                   st.push(s.charAt(i++));
               }
               else if(s.charAt(i)==')'){
                   ans.append(add(st));i++;
               }
               else {
                   if(st.isEmpty()){
                       st.push(s.charAt(i));
                       i++;continue;
                   }
                   int in = p.indexOf(s.charAt(i));
                   int in1 = p.indexOf(st.peek());
                   if((in+1==in1||in-1==in1||in==in1)|| in1>in ){
                       ans.append(st.pop());
                   }
                   else {
                       st.push(s.charAt(i));
                       i++;
                   }
               }

        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        System.out.println(ans);
    }
}
