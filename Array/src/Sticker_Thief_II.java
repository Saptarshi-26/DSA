import java.util.*;

public class Sticker_Thief_II {
    public static int maxValue(int[] arr) {
        // code here
        if (arr.length == 1) return arr[0];
        if (arr.length == 2) return Math.max(arr[0], arr[1]);
        int[] dp1 = {arr[1], arr[0]};
        int[] dp2 = {arr[2], arr[1]};
        for (int i = 2; i < arr.length; i++) {
            if (i < arr.length - 1) {
                int temp = dp1[0];
                dp1[0] = arr[i] + dp1[1];
                dp1[1] = Math.max(temp, dp1[1]);
            }
            if (i > 2) {
                int temp = dp2[0];
                dp2[0] = arr[i] + dp2[1];
                dp2[1] = Math.max(temp, dp2[1]);
            }
        }
        return Math.max(Math.max(dp1[0], dp1[1]), Math.max(dp2[0], dp2[1]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        System.out.println(maxValue(arr));
    }
}
