import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Alien_Dictionary {

    public char[] orderCheck(String word1, String word2) {
        char[] ch = {' ', ' '};
        int i = 0;
        for (; i < Math.min(word1.length(), word2.length()); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                ch[0] = word1.charAt(i);
                ch[1] = word2.charAt(i);
                return ch;
            }
        }
        if (word1.length() > word2.length())
            return null;
        return ch;
    }

    public LinkedHashSet<Character> order(HashSet<Character> currentLayer,
                                          HashMap<Character, HashSet<Character>> fromMap,
                                          HashMap<Character, LinkedHashSet<Character>> dp,
                                          HashSet<Character> visited) {


        LinkedHashSet<Character> layerOder = new LinkedHashSet<>();
        for (char ch : currentLayer) {

            if (visited.contains(ch)) return null;

            LinkedHashSet<Character> temp = new LinkedHashSet<>();
            if (dp.containsKey(ch)) {
                temp.addAll(dp.get(ch));
                temp.add(ch);
            } else if (!fromMap.containsKey(ch)) {
                temp.add(ch);
            } else {
                visited.add(ch);
                LinkedHashSet<Character> nullCheckSet = order(fromMap.get(ch), fromMap, dp, visited);
                if (nullCheckSet == null) return null;
                dp.put(ch, temp);
                temp.addAll(new LinkedHashSet<>(nullCheckSet));
                temp.add(ch);
                visited.remove(ch);
            }

            layerOder.addAll(temp);

        }
        return layerOder;


    }

    public String findOrder(String[] words) {
        // code here

        HashSet<Character> totalSet = new HashSet<>();

        IntStream.range(0, words.length).forEach(i ->
        {
            IntStream.range(0, words[i].length()).
                    forEach(j -> {
                        totalSet.add(words[i].charAt(j));
                    });
        });

        HashSet<Character> edge = new HashSet<>();

        HashMap<Character, HashSet<Character>> fromMap = new HashMap<>();

        for (int i = 1; i < words.length; i++) {
            char[] ch = orderCheck(words[i - 1], words[i]);
            if (ch == null) return "";
            if (ch[0] != ' ') {
                edge.add(ch[0]);
                if (fromMap.containsKey(ch[1])) {
                    fromMap.get(ch[1]).add(ch[0]);
                } else fromMap.put(ch[1], new HashSet<>(Set.of(ch[0])));
            }
        }

        HashSet<Character> startingSet = new HashSet<>();
        totalSet.stream().filter(ch -> !edge.contains(ch)).forEach(startingSet::add);
        HashSet<Character> ansSet = order(startingSet, fromMap, new HashMap<>(), new HashSet<>());
        if (ansSet == null || ansSet.size() != totalSet.size()) return "";
        return ansSet.stream().map(String::valueOf).collect(Collectors.joining(""));


    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no pof words ");
        String[] words = new String[sc.nextInt()];
        System.out.println("enter the words ");
        IntStream.range(0, words.length).forEach(i -> words[i] = sc.next());
        System.out.println(new Alien_Dictionary().findOrder(words));
    }
}

