import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Partition_Labels {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastIndex.put(ch, i);
        }
        List<Integer> size = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int temp = lastIndex.get(s.charAt(i));
            int j = i;
            while (j < s.length() && j <= temp) {
                int index = lastIndex.get(s.charAt(j));
                if (index > temp) {
                    temp = index;
                }
                j++;
            }
            size.add(j - i);
            i = j;
        }
        return size;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string ");
        String str = sc.next();
        System.out.println(new Partition_Labels().partitionLabels(str));
    }
}
