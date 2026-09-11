import java.util.*;

public class Word_Ladder { // dfs , tle in leetcode
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

    public int reachWord(String beginWord, String endWord, List<String> worsList,
                          HashSet<Integer> visited, int index) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < worsList.size(); i++) {
            if (!visited.contains(i) &&
                    beginWord.length() == worsList.get(i).length() &&
                    transformCheck(beginWord, worsList.get(i))) {
                visited.add(i);
                int temp = reachWord(worsList.get(i), endWord, worsList, visited, i);
                if (temp != Integer.MAX_VALUE) {
                    min = Math.min(min, temp + 1);
                }
                visited.remove(i);
            }
        }

        return min;

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       int ans = reachWord(beginWord,endWord,wordList, new HashSet<>(),0);
       return ans == Integer.MAX_VALUE ? 0 : ans;
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
        System.out.println(new Word_Ladder().ladderLength(beginWord, endWord, wordList));
    }
}
