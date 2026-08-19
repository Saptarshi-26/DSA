import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

public class Maximum_Number_of_Occurrences_of_a_Substring {
    public void substringsFind(String s, int i, int j, int minSize, int[][] dp, HashMap<String, Integer> map, int[] chars) {
        if (dp[i][j] == 0 && j<=i ) {
            String substr = s.substring(j, i + 1);
            int ch_upper = s.charAt(i) - 97;
            int ch_lower = s.charAt(j) - 97;
            boolean isPresent = map.containsKey(substr);
            map.put(substr, isPresent ? map.get(substr) + 1 : 1);
            if (i - j >= minSize) {
                chars[ch_upper]--;
                substringsFind(s, i - 1, j, minSize, dp, map, chars);
                chars[ch_upper]++;

                chars[ch_lower]--;
                substringsFind(s, i, j + 1, minSize, dp, map, chars);
                chars[ch_lower]++;
            }
            dp[i][j] = 1;
        }
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int[] chars = new int[26];
        int count_letters = 0;
        int i = 0;
        int j = 0;
        int[][] dp = new int[s.length()][s.length()];
        HashMap<String, Integer> map = new HashMap<>();
        while (i < s.length()) {
            int ch_upper = s.charAt(i) - 97;

            if (chars[ch_upper] == 0) {
                count_letters++;
            }

            chars[ch_upper]++;

            if (count_letters > maxLetters) {
                while (count_letters > maxLetters) {
                    int ch_lower = s.charAt(j) - 97;
                    chars[ch_lower]--;
                    count_letters = chars[ch_lower] == 0 ? count_letters - 1 : count_letters;
                    j++;
                }
            } else if ((i + 1) - j > maxSize) {
                while ((i + 1) - j > maxSize) {
                    int ch_lower = s.charAt(j) - 97;
                    chars[ch_lower]--;
                    count_letters = chars[ch_lower] == 0 ? count_letters - 1 : count_letters;
                    j++;
                }
            }
            if((i+1)-j>=minSize) {
                substringsFind(s, i, j, minSize, dp, map, chars);
            }
            i++;
        }
        Optional<Integer> ans = map.keySet().stream().max(Comparator.comparingInt(map::get)).map(map::get);
     return ans.orElse(0);
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the String ");
        String s = sc.next();
        System.out.println("enter the maximum letters ");
        int maxLetter = sc.nextInt();
        System.out.println("enter the min size of substring ");
        int minSize = sc.nextInt();
        System.out.println("enter the maz size of the substring ");
        int maxSize = sc.nextInt();

        System.out.println(new Maximum_Number_of_Occurrences_of_a_Substring().
                maxFreq(s, maxLetter, minSize, maxSize));

    }
}
