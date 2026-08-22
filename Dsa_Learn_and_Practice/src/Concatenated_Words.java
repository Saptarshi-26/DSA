import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Concatenated_Words {
    int check(HashMap<Character, List<String>> map, String s, int i, HashMap<String, Integer> dp) {
        if (dp.containsKey(s.substring(i))) return dp.get(s.substring(i));
        if (i == s.length()) return 0;
        char ch = s.charAt(i);
        if (!map.containsKey(ch)) return -1;
        for (String word : map.get(ch)) {
            if (s.substring(i).startsWith(word)) {
                if (i == 0 && word.length() == s.length()) {
                    dp.put(s.substring(i), 0);
                    continue;
                }
                int count = check(map, s, i + word.length(), dp);
                if (count != -1) {
                    dp.put(s.substring(i), count);
                    return count + 1;
                }
            }
        }
        if (!dp.containsKey(s.substring(i))) dp.put(s.substring(i), -1);
        return -1;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashMap<Character, List<String>> map = Arrays.stream(words).collect(Collectors.groupingBy(x -> x.charAt(0), HashMap::new, Collectors.toList()));
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (check(map, word, 0, new HashMap<>()) > 0) ans.add(word);
        }
        return ans;

    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of words ");
        String[] words = new String[sc.nextInt()];
        sc.nextLine();
        System.out.println("enter the words ");
        IntStream.range(0, words.length).forEach(i -> words[i] = sc.nextLine());
        System.out.println(new Concatenated_Words().findAllConcatenatedWordsInADict(words));

    }
}
