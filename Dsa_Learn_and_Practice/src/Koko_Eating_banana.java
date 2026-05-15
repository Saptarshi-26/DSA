import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Koko_Eating_banana {
    static boolean koko(int[] arr, int n, int k) {
        for (int x : arr) {
            if (k < 0) return false;
            k-= x<n?1:x%n==0?x/n:(x/n)+1;
        }
        return k>=0;

    }

    static public int kokoEat(int[] arr, int k) {
        // code here
        int min = arr[0];
        int max = arr[0];
        for (int x : arr) {
            max = Math.max(max, x);
        }
        int ans = max;
        int i = 1;
        int j = max;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (!koko(arr, mid, k)) {
                i = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                j = mid - 1;
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
        System.out.println("enter the no of hours ");
        int k = sc.nextInt();
        System.out.println(kokoEat(arr,k));

    }
}
