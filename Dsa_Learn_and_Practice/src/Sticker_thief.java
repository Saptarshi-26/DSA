import java.util.*;

public class Sticker_thief {

    public static int findMaxSum(int[] arr) {
        // code here
        int a = arr[arr.length - 1];
        int b = arr[arr.length - 2];
        for (int i = arr.length - 3; i >= 0; i--) {
            int temp = arr[i] + a;
            a = Math.max(a, b);
            b = temp;
        }
        return Math.max(a, b);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findMaxSum(arr));
    }
}
