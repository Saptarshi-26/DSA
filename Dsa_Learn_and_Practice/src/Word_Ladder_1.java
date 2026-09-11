import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Word_Ladder_1 {
    boolean transformCheck(String wrd1, String wrd2) {
        int i = 0;
        int j = wrd1.length() - 1;
        int count = 0;
        while (i < j) {
            if (wrd1.charAt(i) != wrd2.charAt(i)) {
                count++;
            }
            if (wrd1.charAt(j) != wrd2.charAt(j)) {
                count++;
            }
            i++;
            j--;
            if (count == 2) return false;
        }
        if (i == j && wrd1.charAt(i) != wrd2.charAt(j)) count++;
        return count == 1;
    }

    public int distance(List<String> worsList, List<String> targetLayer, String beginWord) {

        List<String> nextLayer = new ArrayList<>();
        List<String> nextWordList = new ArrayList<>();
        for (String word : worsList) {
            int i = 0;
            for (; i < targetLayer.size(); i++) {
                String word1 = targetLayer.get(i);
                if (transformCheck(word, word1)) {
                    if (word.equals(beginWord)) return 2;
                    nextLayer.add(word);
                    break;
                }
            }
            if (i == targetLayer.size()) nextWordList.add(word);
        }
        if (nextLayer.isEmpty()) return 0;
        else {
            int ans = distance(nextWordList, nextLayer, beginWord);
            return ans > 0 ? ans + 1 : 0;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        if (wordList.contains(endWord)) {
            wordList.remove(endWord);
        } else return 0;
        List<String> targetLayer = new ArrayList<>(List.of(endWord));
        return distance(wordList, targetLayer, beginWord);
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of words ");
        int n = sc.nextInt();
        List<String> wordList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            wordList.add(sc.next());
        }
        System.out.println("enter the beginning word ");
        String beginWord = sc.next();
        System.out.println("enter the ending word ");
        String endWord = sc.next();
        System.out.println(new Word_Ladder_1().ladderLength(beginWord, endWord, wordList));
    }
}
