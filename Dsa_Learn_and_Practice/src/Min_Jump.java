import java.util.*;

public class Min_Jump {
    static int min(int[] arr, int i) {
        if (arr[i] == 0) return -1;
        if (i + arr[i] >= arr.length - 1) return 1;
        int max = -1;
        int index = -1;
        for (int j = i + 1; j < arr.length && j <= i + arr[i]; j++) {
            if (arr[j] != 0) {
                if (j + arr[j] > max) {
                    max = j + arr[j];
                    index = j;
                }
            }
        }
        if (index == -1) return -1;
        int ans = min(arr, index);
        return ans == -1 ? -1 : ans + 1;
    }

    public static boolean canJump(int[] arr) {
        if (min(arr, 0) == 0) return false;
        return min(arr, 0) != -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        System.out.println(canJump(arr));
    }
}
