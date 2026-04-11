import java.util.*;

public class Merge_Intervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        List<int[]> list = new ArrayList<>();
        int j = 0;
        int max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            max = Math.max(intervals[i - 1][1], max);
            if (intervals[i][0] > max) {
                int[] temp = {intervals[j][0], max};
                list.add(temp);
                j = i;
            }
        }
        max = Math.max(intervals[intervals.length - 1][1], max);
        list.add(new int[]{intervals[j][0], max});
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[][] interval = new int[sc.nextInt()][2];
        System.out.println("enter the intervals ");
        for (int i = 0; i < interval.length; i++) {
            interval[i][0] = sc.nextInt();
            interval[i][1] = sc.nextInt();
        }
        Arrays.stream(merge(interval)).forEach(x -> System.out.println(x[0] + " " + x[1]));
    }
}
