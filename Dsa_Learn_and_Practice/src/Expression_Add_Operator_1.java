import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Expression_Add_Operator_1 {

    public static List<String> add_operators(String s, int i, String exp, long prev_no, long sum, int target, char op) {
        System.out.println(exp + " " + sum);
        if (i == s.length()) return sum == target ? new ArrayList<>(List.of(exp)) : new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for (int j = i + 1; j <= s.length() && j - i <= 9; j++) {
            int current_no = Integer.parseInt(s.substring(i, j));
            if (i == 0) {
                ans.addAll(add_operators(s, j, exp + current_no, current_no, sum + current_no, target, '+'));
                if (s.charAt(i) == '0') break;
                continue;
            }

            ans.addAll(add_operators(s, j, exp + "+" + current_no, current_no, sum + current_no, target, '+'));
            ans.addAll(add_operators(s, j, exp + "-" + current_no, current_no, sum - current_no, target, '-'));

            if (op == '+') {
                ans.addAll(add_operators(s, j, exp + "*" + current_no, prev_no * current_no, (sum - prev_no) + (prev_no * current_no), target, '+'));
            } else if (op == '-') {
                ans.addAll(add_operators(s, j, exp + "*" + current_no, prev_no * current_no, (sum + prev_no) - (prev_no * current_no), target, '-'));
            }

            if (s.charAt(i) == '0') break;
        }
        return ans;


    }

    public static List<String> addOperators(String num, int target) {
        if (num.equals(Integer.toString(target))) return new ArrayList<>(List.of(num));
        return add_operators(num, 0, "", 0, 0, target, ' ');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string og digits ");
        String s = sc.next();
        System.out.println("enter the target ");
        int n = sc.nextInt();
        System.out.println(addOperators(s, n));

    }
}
