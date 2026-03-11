import java.util.Scanner;

public class Missing_Number {
    static int missingNum(int[] arr) {
        // code here
        for (int i = 0; i < arr.length; ) {
            if (arr[i] > arr.length) {
                i++;
                continue;
            }
            if (arr[i] != i + 1) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            } else i++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) return i + 1;
        }
        return arr[arr.length - 1] + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of tbe array ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        System.out.println(missingNum(arr));
    }
}
