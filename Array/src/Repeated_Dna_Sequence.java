import java.util.*;

public class Repeated_Dna_Sequence {
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 10)
            return ans;
        StringBuilder sb = new StringBuilder(s.substring(0, 10));
        HashMap<String, Integer> h = new HashMap<>(Map.of("" + sb, 1));
        for (int i = 10; i < s.length(); i++) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            String b = sb.toString();
            h.put(b, h.getOrDefault(b, 0) + 1);
            if (h.get(b) == 2)
                ans.add(b);

        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string ");
        String s = sc.next();
        System.out.println(findRepeatedDnaSequences(s));
    }
}
