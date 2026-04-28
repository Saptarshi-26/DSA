import java.util.*;

public class Smallest_range_covering_elements_from_k_lists_2 {
    public void smallest(int i, int j, HashMap<Integer, Integer> map, List<int[]> list, int[] ans, int[][] dp) {
        if (i >= j || dp[i][j] != 0) return;
        int upper = list.get(j)[1];
        int lower = list.get(i)[1];
        int upper_list_index = list.get(j)[0];
        int lower_list_index = list.get(i)[0];
        if (ans[1] - ans[0] > (upper - lower)) {
            ans[1] = upper;
            ans[0] = lower;
        }
        if (map.get(upper_list_index) - 1 > 0) {
            map.put(upper_list_index, map.get(upper_list_index) - 1);
            smallest(i, j - 1, map, list, ans, dp);
            map.put(upper_list_index, map.get(upper_list_index) + 1);
        }
        if (map.get(lower_list_index) - 1 > 0) {
            map.put(lower_list_index, map.get(lower_list_index) - 1);
            smallest(i + 1, j, map, list, ans, dp);
            map.put(lower_list_index, map.get(lower_list_index) + 1);
        }
        dp[i][j] = 1;


    }

    public int[] smallestRange(List<List<Integer>> nums) {

        int min = nums.get(0).get(0);
        int max = min;

        List<int[]> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.put(i, nums.get(i).size());
            for (int x : nums.get(i)) {
                list.add(new int[]{i, x});
            }
        }
        if (nums.size() == 1) return new int[]{min, min};
        list.sort(Comparator.comparingInt(a -> a[1]));
        int[][] dp = new int[list.size()][list.size()];
        int[] ans = {0, Integer.MAX_VALUE};
        smallest(0, list.size() - 1, map, list, ans, dp);
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the lists");
        List<List<Integer>> nums = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            String[] arr = line.trim().split("\\s+");
            List<Integer> list = new ArrayList<>();
            for (String x : arr) {
                list.add(Integer.parseInt(x));
            }
            nums.add(list);
        }

        Smallest_range_covering_elements_from_k_lists_2 smallestRangeCoveringElementsFromKLists = new Smallest_range_covering_elements_from_k_lists_2();
        System.out.println(Arrays.stream(smallestRangeCoveringElementsFromKLists.smallestRange(nums)).boxed().toList());

    }
}
