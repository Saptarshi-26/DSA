import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Non_Overlapping_intervals {
    public static int eraseOverlapIntervals(int[][] arr) {

        TreeMap<Integer, int[]> sort_map = Arrays.stream(arr).
                collect(Collectors.toMap(x -> x[0], Function.identity(),
                        BinaryOperator.minBy((a, b) -> a[1] - b[1]), TreeMap::new));

        LinkedHashMap<int[], Integer> min_chain = new LinkedHashMap<>();

        int max_ans=1;

        for (int a : sort_map.keySet()) {
            int[] intervals = sort_map.get(a);
            int max = 1;
            for (int[] x : min_chain.keySet()) {
                if (x[1] <= intervals[0]) {
                    max = Math.max(min_chain.get(x) + 1, max);
                }
                else break;
            }
            max_ans=Math.max(max,max_ans);
            min_chain.put(intervals, max);
        }


        return arr.length - max_ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[][] arr = new int[sc.nextInt()][2];
        System.out.println("ënter the intervals ");
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        System.out.println(eraseOverlapIntervals(arr));
    }
}
