import java.util.*;

public class Total_Decoding_Messages {
    public static int countWays(String digits) {
        // code here
        if (digits.length() == 1) return digits.charAt(0) == '0' ? 0 : 1;
        char last_char = digits.charAt(digits.length() - 1);
        int next_prev = (last_char) == '0' ? 0 : 1;
        int prev = 0;
        int ans = 0;
        char c = digits.charAt(digits.length() - 2);
        if (c != '0') {
            prev = next_prev;
            if (Integer.parseInt(("" + c + last_char)) <= 26) prev++;
        }
        ans = prev;
        for (int i = digits.length() - 3; i >= 0; i--) {
            int current_digit = (int) digits.charAt(i) - 48;
            if (current_digit == 0) {
                next_prev = prev;
                ans = prev = 0;
                continue;
            }
            if (digits.charAt(i + 1) == '0') {
                if (Integer.parseInt("" + digits.charAt(i) + '0') <= 26) {
                    ans = next_prev;
                } else {
                    return 0;
                }
            } else {
                String no = "" + digits.charAt(i) + digits.charAt(i + 1);
                if (Integer.parseInt(no) <= 26) ans += next_prev;
            }
            next_prev = prev;
            prev = ans;

        }
        return ans;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string ");
        System.out.println(countWays(sc.next()));
    }
}
