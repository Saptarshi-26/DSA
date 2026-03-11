import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Longest_String_Chain_1 {
    static boolean ispred(String s, String ss) {
        //if(ss.length()+1!=s.length())return false;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < ss.length()) {
            if (j < i && s.charAt(i) != ss.charAt(j)) return false;
            if (s.charAt(i) == ss.charAt(j)) {
                j++;
            }
            i++;
        }
        return true;
    }

    public static int lsc(String s, HashMap<String, Integer> dp, HashMap<String, ArrayList<String>> h) {
        if (dp.containsKey(s)) return dp.get(s);
        if (h.get(s).isEmpty()) {
            dp.put(s, 1);
            return 1;
        }
        int max = 0;
        for (String x : h.get(s)) {
            max = Math.max(max, lsc(x, dp, h));
        }
        dp.put(s, max + 1);
        return max + 1;

    }

    public static int longestStringChain(String[] arr) {
        // code here
        HashMap<Integer, ArrayList<String>> hlen = new HashMap<>();
        HashMap<String, ArrayList<String>> h = new HashMap<>();
        for (String s : arr) {
            if (!h.containsKey(s)) h.put(s, new ArrayList<>());
            if (!hlen.containsKey(s.length())) hlen.put(s.length(), new ArrayList<>(List.of(s)));
            else hlen.get(s.length()).add(s);
        }
        //ispred(x,s)
        for (String s : arr) {
            if (hlen.containsKey(s.length() - 1)) {
                for (String x : hlen.get(s.length() - 1)) {
                    if (ispred(s, x)) h.get(x).add(s);
                }
            }
        }

        int max = 0;
        HashMap<String, Integer> dp = new HashMap<>();
        for (String s : h.keySet()) {
            max = Math.max(max, lsc(s, dp, h));
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        String[] arr = new String[sc.nextInt()];
        //sc.nextLine();
        System.out.println("Enter the Strings ");
        for (int i = 0; i < arr.length; i++) arr[i] = sc.next();
        System.out.println(longestStringChain(arr));
    }
}
