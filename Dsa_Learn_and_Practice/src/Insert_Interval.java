import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Insert_Interval {
    public int insertOnly(int[][] intervals, int[] newInterval, List<int[]> update) {

        if (newInterval[0] < intervals[0][0]) {
            update.add(newInterval);
            return -1;
        }
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
                update.add(new int[]{intervals[i][0], Math.max(intervals[i][1], newInterval[1])});
                return i;
            }
            if (newInterval[0] < intervals[i][0]) {
                update.add(newInterval);
                return i - 1;
            }
            update.add(intervals[i]);
        }
        update.add(newInterval);
        return intervals.length;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ans;
        if (intervals.length == 0) {
            ans = new int[1][2];
            ans[0] = newInterval;
            return ans;
        }
        List<int[]> update = new ArrayList<>();
        int lastIndex = insertOnly(intervals, newInterval, update);
        if (lastIndex == intervals.length)
            return ans = update.toArray(int[][]::new);
        for (int i = lastIndex + 1; i < intervals.length; i++) {
            if (intervals[i][0] >= update.getLast()[0] && intervals[i][0] <= update.getLast()[1]) {
                update.set(update.size() - 1, (new int[]{update.getLast()[0], Math.max(intervals[i][1], update.getLast()[1])}));
            } else update.add(intervals[i]);
        }

        return update.toArray(int[][]::new);


    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of intervals ");
        int[][] intervals = new int[sc.nextInt()][2];
        System.out.println("enter the intervals ");
        for (int i = 0; i < intervals.length; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        System.out.println("enter the new interval to be inserted ");
        int[] newInterval = new int[2];
        newInterval[0] = sc.nextInt();
        newInterval[1] = sc.nextInt();
        Arrays.stream(new Insert_Interval().insert(intervals, newInterval)).
                map(x -> new ArrayList(List.of(x[0], x[1]))).toList().
                forEach(System.out::println);

    }
}
