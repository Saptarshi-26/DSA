import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Word_Break {
    public static boolean word_break(String s, HashMap<Character, ArrayList<String>> h,
                                     HashMap<String, Boolean> stringBooleanHashMap) {

        if (stringBooleanHashMap.containsKey(s)) return false;

        if (s.isEmpty()) return true;

        if (!h.containsKey(s.charAt(0))) return false;

        for (String x : h.get(s.charAt(0))) {

            if (x.length() <= s.length()) {

                if (s.startsWith(x)) if

                (word_break(s.substring(x.length()), h, stringBooleanHashMap))

                    return true;
            }
        }
        stringBooleanHashMap.put(s, false);

        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        HashMap<Character, ArrayList<String>> h = new HashMap<>();

        for (String x : wordDict) {

            if (!h.containsKey(x.charAt(0))) h.put(x.charAt(0), new ArrayList<>(List.of(x)));

            else h.get(x.charAt(0)).add(x);
        }
        return word_break(s, h, new HashMap<>());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the word ");

        String s = sc.next();

        System.out.println("enter the length of the dictionary ");

        int length = sc.nextInt();

        System.out.println("enter the words of the dictionary ");

        ArrayList<String> dict = new ArrayList<>();

        for (int i = 0; i < length; i++)
            dict.add(sc.next());

        System.out.println(wordBreak(s, dict));
    }
}
