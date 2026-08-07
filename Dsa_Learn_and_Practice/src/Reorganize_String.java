import java.util.Scanner;

public class Reorganize_String {

    public String reorganizeString(String s) {
        int j = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                if (j >= i) {
                    for (; j < s.length() - 1; j++) {
                        if (s.charAt(j) != s.charAt(i) && s.charAt(j + 1) != s.charAt(i)) {
                            break;
                        }
                    }
                    if (j == s.length() - 1 && s.charAt(j) == s.charAt(i)) {
                        j = 0;
                    }
                }
                if (j < i) {
                    for (; j < i; j++) {
                        if (j == 0 && s.charAt(j) != s.charAt(i)) break;
                        if (s.charAt(j) != s.charAt(i) && s.charAt(j + 1) != s.charAt(i)) {
                            break;
                        }
                    }
                    if (j == i) return "";
                }


                char temp = s.charAt(i);
                StringBuilder s1 = new StringBuilder();
                if (j == 0 || j == s.length() - 1) {
                    s1 = new StringBuilder(s.substring(0, i));
                    if (i < s.length() - 1) s1.append(s.substring(i + 1));
                    if (j == 0) {
                        s1.insert(0, temp);
                    }
                    if (j == s.length() - 1) {
                        s1.append(temp);
                    }
                } else {
                    for (int k = 0; k < s.length(); k++) {
                        if (k == i) continue;
                        if (k == j) {
                            s1.append(s.charAt(k)).append(temp);
                            continue;
                        }
                        s1.append(s.charAt(k));
                    }


                }
                s = s1.toString();
                i--;
            }


            if(i==j)j++;

        }
         return s;
        }


    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string ");
        String s = sc.next();
        System.out.println(new Reorganize_String().reorganizeString(s));
    }
}
