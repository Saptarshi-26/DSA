import java.util.Scanner;

public class Stock_Buy_Sell_Max2_Transaction_Allowed {
    public static int maxProfit(int[] pr) {
        // code her
        
        int[] m = {pr[0], -1};
        int[] m1 = {-1, pr[pr.length - 1]};
        int[] a = new int[pr.length];
        int[] a1 = new int[pr.length];
        int j = pr.length - 2;
        for (int i = 1; i < pr.length; i++, j--) {
            if (pr[i] > m[0]) {
                m[1] = m[1] == -1 ? pr[i] : Math.max(m[1], pr[i]);
            }
            if (pr[i] < m[0]) {
                m[0] = pr[i];
                m[1] = -1;
            }
            if (pr[j] < m1[1]) {
                m1[0] = m1[0] == -1 ? pr[j] : Math.min(m1[0], pr[j]);
            }
            if (pr[j] > m1[1]) {
                m1[1] = pr[j];
                m1[0] = -1;
            }
            a[i] = Math.max(a[i - 1], m[1] != -1 ? m[1] - m[0] : a[i - 1]);
            a1[j] = Math.max(a1[j + 1], m1[0] != -1 ? m1[1] - m1[0] : a1[j + 1]);

        }
        int max = 0;
        for (int i = 1; i < pr.length - 1; i++) {
            max = Math.max(max, a1[i + 1] + a[i]);
        }
        max = Math.max(max, a[a.length - 1]);
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] pr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < pr.length; i++)
            pr[i] = sc.nextInt();
        System.out.println(maxProfit(pr));
    }
}
