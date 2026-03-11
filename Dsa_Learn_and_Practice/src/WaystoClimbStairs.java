import java.util.*;
public class WaystoClimbStairs {
   static int ways(int n ,HashMap<Integer,Integer> h){
        if(n==0)return 1;
        int ways=0;
        if(h.containsKey(n))return h.get(n);
        ways+=ways(n-1,h)+((n-2)>=0?ways(n-2,h):0);
        h.put(n,ways);
        return ways;
       }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stairs ");
        int n=sc.nextInt();
        HashMap<Integer,Integer> h = new HashMap<>();
        System.out.println(ways(n,h));
    }
}
