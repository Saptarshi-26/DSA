import java.util.HashMap;
import java.util.Scanner;

public class Burst_Balloons { // Tle on gfg and leetcode

    int prev(int[] nums, int left) {
        for (; left >= 0 && nums[left] == -1; left--) ;
        return left;
    }

    int next_index(int[] nums, int j) {
        for (; j < nums.length && nums[j] == -1; j++) ;
        return j;
    }


    int maxCoin(int[] nums, int i, int sum, int count) {
        if (count == nums.length) return sum;

        int ans = 0;

        for (int j = i; j < nums.length; j++) {
            if (nums[j] == -1) continue;

            int prev_index = prev(nums, j - 1);
            int prev = prev_index == -1 ? 1 : nums[prev_index];

            int next_index = next_index(nums, j + 1);
            int next = next_index == nums.length ? 1 : nums[next_index];

            int temp = nums[j];
            nums[j] = -1;

            ans = Math.max(ans, maxCoin(nums, 0, sum + (prev * temp * next), count + 1));

            nums[j] = temp;


        }

        // System.out.println(Arrays.stream(nums).mapToObj(Integer::toString).collect(Collectors.joining(" ")));


        return ans;


    }

    public int maxCoins(int[] nums) {

        HashMap<String, Integer> dp_map = new HashMap<>();
        return maxCoin(nums, 0, 0, 0);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] nums = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        Burst_Balloons burst_balloons = new Burst_Balloons();
        System.out.println(burst_balloons.maxCoins(nums));
    }
}
