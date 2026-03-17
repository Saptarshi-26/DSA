import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public  class Minimum_Window_Substring_1 {

    public static String minWindow(String s, String t) {

        HashMap<Character, Long> char_freq = (HashMap<Character, Long>) s.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        int count = 0;

        int i = 0;
        int j = i;
        String ans = s;
        while (i < s.length()) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!char_freq.containsKey(ci)) {
                i++;
                continue;
            }
            if (count == char_freq.size()) {
                if (char_freq.containsKey(ci)) {
                    char_freq.put(ci, char_freq.get(ci) + 1);
                    if (char_freq.get(ci) > 0) count--;
                }
                i++;
            } else {
                if (char_freq.containsKey(cj)) {
                    char_freq.put(cj, char_freq.get(cj) - 1);
                    if (char_freq.get(cj) == 0) count++;
                }
                if (count != char_freq.size()) j++;
                else {
                    String b = s.substring(i, j + 1);
                    ans = b.length() < ans.length() ? b : ans;
                }

            }
        }

        return ans;


    }


public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter the string ");
    String s = sc.next();
    System.out.println();
}
}
