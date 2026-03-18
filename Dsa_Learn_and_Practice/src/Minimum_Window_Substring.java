import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Minimum_Window_Substring {

    public static String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";
        HashMap<Character, Long> char_freq = t.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(x -> x, HashMap::new, Collectors.counting()));

        int count = 0;

        int i = -1;
        while ((i + 1) < s.length() && !char_freq.containsKey(s.charAt(++i))) ;
        int j = i;
        String ans = s + s;
        while (i < s.length() && j < s.length()) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (char_freq.containsKey(cj)) {
                if (!char_freq.containsKey(ci)) {
                    i++;
                    if (i >= s.length()) break;
                    if (char_freq.containsKey(s.charAt(i)) && count != char_freq.size()) j++;
                    continue;
                }
                if (count == char_freq.size()) {
                    String temp = s.substring(i, j + 1);
                    ans = temp.length() < ans.length() ? temp : ans;
                    char_freq.put(ci, char_freq.get(ci) + 1);
                    i++;
                    if (char_freq.get(ci) > 0) count--;

                    if (i >= j || char_freq.containsKey(s.charAt(i))) {
                        if (count < char_freq.size()) {
                            j++;
                        }
                    }
                } else {
                    char_freq.put(cj, char_freq.get(cj) - 1);
                    if (char_freq.get(cj) == 0) count++;
                    if (count != char_freq.size()) j++;
                }
            } else j++;
        }
        if (ans.length() > s.length()) ans = "";

        return ans;


    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string ");
        String s = sc.next();
        System.out.println("enter the target string ");
        String t = sc.next();
        System.out.println(minWindow(s, t));
    }
}
