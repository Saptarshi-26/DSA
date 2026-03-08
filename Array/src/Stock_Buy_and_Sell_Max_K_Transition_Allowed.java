import java.util.*;

public class Stock_Buy_and_Sell_Max_K_Transition_Allowed {
    static int maxProfit(int[] pr, int k) {
        // code here
        int[][] max = new int[pr.length][k + 1];
        int m = 0;
        for (int i = pr.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < pr.length; j++) {
                if (pr[i] < pr[j]) {
                    int diff = pr[j] - pr[i];
                    max[i][1] = Math.max(diff, max[i][1]);
                    m = Math.max(m, max[i][1]);
                    for (int x = 1; x < k + 1 && j + 1 < pr.length; x++) {
                        if (x + 1 <= k && max[j + 1][x] > 0) {
                            int temp = max[j + 1][x] + max[i][1];
                            max[i][x + 1] = Math.max(temp, max[i][x + 1]);
                            m = Math.max(m, temp);
                        }
                    }
                }

            }
            for (int x = 0; x <= k; x++) {
                max[i][x] = Math.max(max[i + 1][x], max[i][x]);
            }

        }
        return m;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        System.out.println("enter the maximum transaction allowed ");
        int k = sc.nextInt();
        System.out.println(maxProfit(arr, k));
    }
}
