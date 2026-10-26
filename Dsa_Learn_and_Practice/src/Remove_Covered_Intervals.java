import java.util.*;
import java.util.stream.IntStream;

public class Remove_Covered_Intervals {
    public int removeCoveredIntervals(int[][] intervals) {


        List<int[]> increasing = Arrays.stream(intervals).
                sorted((a,b)-> a[0]==b[0]?Integer.
                        compare(a[1],b[1]):Integer.compare(a[0],b[0])).
                toList();

        List<int[]> decreasing = Arrays.stream(intervals).
                sorted((a,b)-> a[1]==b[1]?Integer.
                        compare(b[0],a[0]):Integer.compare(a[1],b[1])).
                        toList().reversed();

        HashMap<Integer, Integer> mapIncreasing = new HashMap<>();

        for (int i = 0; i < increasing.size(); i++) {
            if (!mapIncreasing.containsKey(increasing.get(i)[0])) {
                mapIncreasing.put(increasing.get(i)[0], i);
            }
        }

        HashSet<int[]> removed = new HashSet<>();
        int count = 0;

        for (int i = 0; i < decreasing.size(); i++) {
            if (removed.contains(decreasing.get(i))) continue;
            int index = mapIncreasing.get(decreasing.get(i)[0]);
            for (; index < increasing.size(); index++) {
                if (removed.contains(increasing.get(index))) continue;
                if(decreasing.get(i)==increasing.get(index))continue;
                if (increasing.get(index)[0] >= decreasing.get(i)[0] &&
                        increasing.get(index)[1] <= decreasing.get(i)[1]) {
                    removed.add(increasing.get(index));
                    count++;
                } else break;
            }
        }

        return intervals.length - count;

    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of intervals ");
        int[][] intervals = new int[sc.nextInt()][2];
        IntStream.range(0, intervals.length).
                forEach(i -> {
                    intervals[i][0] = sc.nextInt();
                    intervals[i][1] = sc.nextInt();
                });
        System.out.println(new Remove_Covered_Intervals().removeCoveredIntervals(intervals));
    }
}
