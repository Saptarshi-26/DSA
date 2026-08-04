import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Maximum_Profit_In_Job_Scheduling {

    public int findIndex(List<Integer> start_times, int val) {
        int i = 0;
        int j = start_times.size() - 1;
        int mid = (start_times.size() - 1) / 2;
        while (i <= j) {
            if (start_times.get(mid) == (val)) {
                return mid;
            } else if (start_times.get(mid) < (val)) {
                i = mid + 1;
            } else j = mid - 1;
            mid = (i + j) / 2;
        }
        if (start_times.get(mid) <= val) {
            if (mid + 1 < start_times.size()) return mid + 1;
            else return -1;
        }
        return mid;

    }

    public int max_profit(TreeMap<Integer, List<int[]>> map, int i,
                          List<Integer> start_times, int[] dp) {

        if (i >= start_times.size()) return 0;
        if (dp[i] != 0) return dp[i];
        int max = 0;

        for (int j = i; j < start_times.size(); j++) {
            if (dp[j] != 0) {
                max = Math.max(max, dp[j]);
                break;
            }
            for (int[] x : map.get(start_times.get(j))) {
                int temp = x[1];
                if (x[0] == start_times.get(j)) {
                    temp = temp + max_profit(map, j + 1, start_times, dp);
                } else {
                    int index = findIndex(start_times, x[0]);
                    if (index != -1) {
                        temp += max_profit(map, index, start_times, dp);
                    }
                }
                max = Math.max(max, temp);
            }
        }
        return dp[i] = max;

    }


    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {


        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        for (int i = 0; i < startTime.length; i++) {
            if (map.containsKey(startTime[i])) {
                map.get(startTime[i]).add(new int[]{endTime[i], profit[i]});
            } else {
                map.put(startTime[i], new ArrayList<>(List.of(new int[]{endTime[i], profit[i]})));
            }
        }
        int[] dp = new int[startTime.length + 1];
        List<Integer> start_times = map.keySet().stream().toList();
        return max_profit(map, 0, start_times, dp);

    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of jobs ");

        int[] startTime = new int[sc.nextInt()];
        int[] endTime = new int[startTime.length];
        int[] profit = new int[startTime.length];

        System.out.println("enter the start times ");

        Stream.iterate(0, i -> i + 1).limit(startTime.length).
                forEach(x -> startTime[x] = sc.nextInt());

        System.out.println("enter the end times ");

        Stream.iterate(0, i -> i + 1).limit(endTime.length).
                forEach(x -> endTime[x] = sc.nextInt());

        System.out.print("enter tbe profits ");

        Stream.iterate(0, i -> i + 1).limit(profit.length).
                forEach(x -> profit[x] = sc.nextInt());

        System.out.println(new Maximum_Profit_In_Job_Scheduling().
                jobScheduling(startTime, endTime, profit));


    }
}
