import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Word_Break_II {
    public List words(int i, String s, HashMap<Character, List<String>> map, List[] dp) {
        if (i >= s.length()) return new ArrayList<>(List.of(new ArrayList<>()));
        if (dp[i] != null) {
            return dp[i];
        }
        List<List<String>> ans = new ArrayList<>();
        if (map.containsKey(s.charAt(i))) {
            for (String word : map.get(s.charAt(i))) {
                if (s.substring(i).startsWith(word)) {
                    List<List<String>> temp = new ArrayList<>(words(i + word.length(), s, map, dp));
                    List<List<String>> temp1 = new ArrayList<>();
                    if (temp.isEmpty()) continue;
                    for (List<String> list : temp) {
                        List<String> copy = new ArrayList<>(list);
                        copy.add(word);
                        temp1.add(copy);
                    }
                    ans.addAll(temp1);
                }
            }
        }
        List<List<String>> copy = new ArrayList<>();
        for (List<String> list : ans) {
            List<String> temp = new ArrayList<>(list);
            copy.add(temp);
        }
        dp[i] = new ArrayList(copy);
        return ans;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Character, List<String>> map = wordDict.stream().
                collect(Collectors.
                        groupingBy(x -> x.charAt(0), HashMap::new, Collectors.toList()));
        List[] dp = new List[s.length() + 1];
        List<List<String>> ans = words(0, s, map, dp);
        List<String> words = new ArrayList<>();
        String word_sen = "";
        for (List<String> list : ans) {
            for (String word : list) {
                word_sen = word + " " + word_sen;
            }
            words.add(word_sen.trim());
            word_sen = "";
        }
        return words;

    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of word ");
        String s = sc.next();
        System.out.println("enter the no words in dictionary ");
        int n = sc.nextInt();
        List<String> wordDict = new ArrayList<String>();
        System.out.println("enter the no of words in dictionary ");
        IntStream.range(0, n).forEach(i -> {
            wordDict.add(sc.next());
        });
        System.out.println(new Word_Break_II().wordBreak(s, wordDict));
    }
}

