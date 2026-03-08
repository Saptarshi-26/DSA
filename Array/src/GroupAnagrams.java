import java.util.*;
public class GroupAnagrams {
   public static String sort(String s){
       char ch[]=s.toCharArray();
       Arrays.sort(ch);
       String ans="";
       for(char x: ch)ans+=x;
       return ans;
   }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of strings that will be provided ");
        int n= sc.nextInt();
        System.out.println("Enter the strings ");
        String[] arr = new String[n];
        for (int i=0;i<n;i++)arr[i]=sc.next();
        HashMap<String,List<String>> h = new HashMap<>();
        List<String> keys = new ArrayList<>();
        for(int i=0;i< arr.length;i++){
            String b= sort(arr[i]);
            if(!h.containsKey(b)){
                List<String > a = new ArrayList<>();
                a.add(arr[i]);
                h.put(b,a);
                keys.add(b);
            }
            else{
                List<String > tem= new ArrayList<>(h.get(b));
                tem.add(arr[i]);
                h.put(b,tem);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String x: keys){
            ans.add(h.get(x));
        }
        System.out.println(ans);
    }

}
