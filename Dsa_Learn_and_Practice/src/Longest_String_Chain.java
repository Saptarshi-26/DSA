import java.util.*;
public class Longest_String_Chain {
    static boolean ispred(String s , String ss){
        if(ss.length()+1!=s.length())return false;
        int i=0;
        int j=0;
        while (i<s.length()&&j<ss.length()){
            if(j<i&&s.charAt(i)!=ss.charAt(j))return false;
            if(s.charAt(i)==ss.charAt(j)){
                j++;
            }
            i++;
        }
        return true;
    }
   public static int lsc(String s , HashMap<String,Integer> dp, HashMap<String ,ArrayList<String >>h){
       if(dp.containsKey(s))return dp.get(s);
       if(h.get(s).isEmpty()){
           dp.put(s,1);
           return 1;
       }
        int max=0;
        for(String x : h.get(s)){
            max=Math.max(max,lsc(x,dp,h));
        }
        dp.put(s,max+1);
        return max+1;
        
   }
    public static int longestStringChain(String[] arr) {
        // code here
          HashMap<String ,ArrayList<String >> h = new HashMap<>();
         for(String s : arr) {
             if(!h.containsKey(s))h.put(s,new ArrayList<>());
             for( String x : h.keySet()){
                 if(ispred(x,s)){
                     h.get(s).add(x);
                 }
                 else if(ispred(s,x)){
                     h.get(x).add(s);
                 }
             }
         }
//         for (String s : h.keySet()){
//             System.out.println(s+" "+h.get(s));
//         }
        int max=0;
         HashMap<String,Integer> dp = new HashMap<>();
         for(String s : h.keySet()){
            max=Math.max(max,lsc(s,dp,h));
         }
         return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        String [] arr = new String[sc.nextInt()];
        //sc.nextLine();
        System.out.println("Enter the Strings ");
        for(int i=0;i<arr.length;i++)arr[i]=sc.next();
        System.out.println(longestStringChain(arr));
    }
}
