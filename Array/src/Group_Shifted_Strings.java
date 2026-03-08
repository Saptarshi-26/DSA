import java.util.*;
public class Group_Shifted_Strings {

  static String gen(String s){
      StringBuilder ans = new StringBuilder();
      for(int i=1;i<s.length();i++){
          int pat = ((s.charAt(i)-s.charAt(i-1))+26)%26;
          ans.append(Integer.toString((pat))).append(" ");
      }
      return ans.toString();
  }
   static public ArrayList<ArrayList<String>> groupShiftedString(String[] arr) {
        // code here
     HashMap<Integer,HashMap<String ,ArrayList<String >>> h = new HashMap<>();
     ArrayList<ArrayList<String >> ans = new ArrayList<>();
       for (String s : arr) {
           if (h.containsKey(s.length())) {
               HashMap<String, ArrayList<String>> temp = h.get(s.length());
               String gen = gen(s);
               if (temp.containsKey(gen)) temp.get(gen).add(s);
               else temp.put(gen, new ArrayList<>(List.of(s)));
           } else {
               h.put(s.length(), new HashMap<>(Map.of(gen(s), new ArrayList<>(List.of(s)))));
           }
       }
     for(int x : h.keySet()){
         for(String s: h.get(x).keySet()){
             ans.add(h.get(x).get(s));
         }
     }
     return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of strings ");
        String [] arr = new String[sc.nextInt()];
        sc.nextLine();
        System.out.println("Enter the Strings ");
        for(int i=0;i< arr.length;i++)arr[i]=sc.nextLine();
        System.out.println(groupShiftedString(arr));


    }
}
