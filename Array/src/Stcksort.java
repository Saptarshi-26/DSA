import java.util.*;
public class Stcksort { // in decending order
  public static void stcksort(Stack<Integer> s, int n){
   if(n==1)return;
   int temp1=s.pop();
   if(s.peek()>temp1){
       int temp2=s.pop();
       s.push(temp1);
       temp1=temp2;
   }
   stcksort(s,--n);
   s.push(temp1);
  }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the stack ");
        int n = sc.nextInt();
        Stack <Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            s.push(sc.nextInt());
        }
        int a=n;
        for(int i=0;i<n;i++){
            stcksort(s,a);
            a--;
        }
        System.out.println(s);
    }
}
