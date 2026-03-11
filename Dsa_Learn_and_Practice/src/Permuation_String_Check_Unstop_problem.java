import java.util.*;
public class Permuation_String_Check_Unstop_problem {


    public static ArrayList<ArrayList<String>> permute(String[] arr, int i){
        if(i==arr.length-1){
            ArrayList<ArrayList<String >> a1= new ArrayList<>(List.of(new ArrayList<>(List.of(arr[i]))));
            return a1;
        }
       ArrayList<ArrayList<String>> a = new ArrayList<>(permute(arr,i+1));
        ArrayList<ArrayList<String >> ans = new ArrayList<>();
        for (ArrayList<String> strings : a) {
            ArrayList<String> temp;
            for (int k = 0; k < strings.size(); k++) {
                temp = new ArrayList<>(strings);
                temp.add(k, arr[i]);
                ans.add(temp);
            }
            temp = new ArrayList<>(strings);
            temp.add(arr[i]);
            ans.add(temp);
        }
        return ans ;
    }

        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner sc = new Scanner(System.in);
            String s=sc.nextLine();
            String[] arr =sc.nextLine().split(" ");
            ArrayList<ArrayList<String >> a1  = new ArrayList<>(permute(arr,0));
            ArrayList<String> a = new ArrayList<>();
            for (ArrayList<String> strings : a1) {
                StringBuilder b = new StringBuilder();
                for (String x : strings) {
                    b.append(x);
                }
                a.add(b.toString());
            }
            ArrayList<Integer> ans = new ArrayList<>();
            for (String string : a) {
                for (int j = 0; j < s.length() - string.length(); j++) {
                    if (string.charAt(0) == s.charAt(j)) {
                        if (string.equals(s.substring(j, j + string.length()))) ans.add(j);
                    }
                }
            }

            System.out.print(ans);
        }
}

