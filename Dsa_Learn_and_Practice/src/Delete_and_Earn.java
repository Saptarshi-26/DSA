import java.util.*;
import java.util.stream.Collectors;

public class Delete_and_Earn {

    public int prev_nextSmallest(List<Integer> sorted, int i) {
        int j = i - 1;
        for (; j >= 0; j--) {
            if (sorted.get(j) < sorted.get(i) - 1) return j;
        }
        return j;
    }

    public int deleteAndEarn(int[] nums) {

        TreeMap<Integer, Long> map = Arrays.stream(nums).boxed().
                collect(Collectors.groupingBy(x -> x, TreeMap::new, Collectors.counting()));

        List<Integer> sorted = map.keySet().stream().toList();

        int[] dp = new int[sorted.size()];
        int[] dp_max = new int[sorted.size()];

        int max = 0;

        for (int i = 0; i < sorted.size(); i++) {
            dp[i] += (int) (map.get(sorted.get(i))*sorted.get(i));
            int last_index = prev_nextSmallest(sorted, i);
            dp[i] += (last_index > -1 ? dp_max[last_index] : 0);
            max = Math.max(dp[i], max);
            dp_max[i]=Math.max(max,i-1>=0?dp_max[i-1]:max);

        }

        return max;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new Delete_and_Earn().deleteAndEarn(arr));
    }

}
