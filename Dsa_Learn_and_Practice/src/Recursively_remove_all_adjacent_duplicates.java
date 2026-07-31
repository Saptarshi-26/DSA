import java.util.Scanner;

public class Recursively_remove_all_adjacent_duplicates {
    public String removeUtil(String s) {
        // code here
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) j++;
            if (j == i + 1) s1.append(s.charAt(i));
            i = j - 1;
        }

        return s1.length() < s.length() ?
                removeUtil(s1.toString()) : s1.toString();

    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string ");
        System.out.print(new Recursively_remove_all_adjacent_duplicates().removeUtil(sc.next()));
    }
}
