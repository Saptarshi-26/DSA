import java.util.Arrays;
import java.util.Scanner;

public class Min_Platform {
    public static int minPlatform(int[] arr, int[] dep) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 1;
        int j = 0;
        int count = 0;
        int max = 0;
        int temp = arr[0];
        while (i < arr.length && j < arr.length) {
            if (arr[i] < dep[j]) {
                count++;
                temp = arr[i];
                i++;
            } else {
                count--;
                temp = dep[j];
                j++;
            }
            max = Math.max(max, count);
        }
        return max + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        int[] dep = new int[arr.length];
        System.out.println("enter the starting time and ending time  ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            dep[i] = sc.nextInt();
        }
        System.out.println(minPlatform(arr, dep));

    }
}
