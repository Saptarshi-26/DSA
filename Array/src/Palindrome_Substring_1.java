import java.util.Scanner;

public class Palindrome_Substring_1 {

    static int chck(String s, int i, int j) {
        int c = 0;
        while ((i >= 0 && j < s.length()) && s.charAt(i) == s.charAt(j)) {
            c++;
            i--;
            j++;
        }
        return c;
    }

    static int chck1(String s, int i, int j) {
        int c = 0;
        while ((i >= 0 && j < s.length()) && s.charAt(i) == s.charAt(j)) {
            c++;
            i--;
            j++;
        }
        return c;
    }

    public static int countPS(String s) {
        // code here
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            ans += ((i - 1 >= 0 && i + 1 < s.length()) ? chck(s, i - 1, i + 1) : 0) + chck1(s, i, i + 1);

        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String ");
        String s = sc.nextLine();
        System.out.println(countPS(s));
    }
}
