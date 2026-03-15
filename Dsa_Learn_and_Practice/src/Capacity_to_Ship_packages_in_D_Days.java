import java.util.Scanner;

public class Capacity_to_Ship_packages_in_D_Days {
    static int leastWeightCapacity(int[] arr, int d) {
        // code here
        int min = arr[0];
        int max = arr[0];

        for (int x : arr) {
            min = Math.max(min, x);
            max += x;
        }

        int left = min;
        int right = max;
        int ans = arr.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            int temp = mid;
            int i = 0;
            int count = 0;
            for (; i < arr.length; i++) {
                if (mid < arr[i]) {
                    count++;
                    if (count > d) break;
                    mid = temp;
                    i--;
                    continue;
                }
                mid -= arr[i];

            }
            if (i == arr.length) count++;
            if (count > d) left = temp + 1;
            else if (count <= d) {
                ans = temp;
                right = temp - 1;
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the number od days ");
        int d = sc.nextInt();
        System.out.println(leastWeightCapacity(arr, d));

    }
}
