import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generate_Parenthesis {
    public static List<String> genP(int n1, int n2, String s) {
        if (n1 == 0) {
            for (int i = 1; i <= n2; i++) s = s + ")";
            return new ArrayList<>(List.of(s));
        }
        ArrayList<String> ans = (ArrayList<String>) genP(n1 - 1, n2, s + "(");
        if(n1<n2)ans.addAll(genP(n1, n2 - 1, s + ")"));
        return ans;
    }

    public static List<String> generateParenthesis(int n) {
        return genP(n-1, n, "(");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no ");
        System.out.println(generateParenthesis(sc.nextInt()));

    }

}
