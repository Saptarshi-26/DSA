import java.util.Scanner;

public class Search_in_Rotated_sorted_array {
    public static int pivot(int[] arr, int i, int j) {
        if (i > j) return -1;
        int mid = (i + j) / 2;
        if (mid > 0 && mid < arr.length - 1) {
            if (arr[mid] < arr[mid - 1] && arr[mid] <= arr[mid + 1]) return mid;
        }
        if (mid == arr.length - 1) {
            if (arr[mid] < arr[mid - 1]) return mid;
        }
        if (i == j) return -1;
        int pivot = -1;
        if (arr[i] > arr[j]) {
            if (arr[mid] <= arr[j]) return pivot(arr, i, mid - 1);
            return pivot(arr, mid + 1, j);
        }
        pivot = pivot(arr, mid + 1, j);
        return pivot == -1 ? pivot(arr, i, mid - 1) : pivot;

    }

    public static boolean search(int[] arr, int target) {
        if (arr.length == 1) return arr[0] == target;
        int pivot = -1;
        int i = -1, j = -1;
        if (arr[0] < arr[arr.length - 1]) {
            i = 0;
            j = arr.length - 1;
        } else {
            pivot = pivot(arr, 0, arr.length - 1);
            if (pivot == -1) {
                return arr[0] == target;
            }
            if (arr[pivot] == target) return true;

            if (target <= arr[arr.length - 1] && target > arr[pivot]) {

                i = pivot + 1;
                j = arr.length - 1;
            } else {
                i = 0;
                j = pivot - 1;
            }
        }
        while (i < j) {
            int mid = (i + j) / 2;
            if (arr[mid] == target) return true;
            if (arr[mid] < target) {
                i = mid + 1;
            } else j = mid - 1;
        }
        return i == j && arr[i] == target;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        int target = sc.nextInt();
        System.out.println(search(arr, target));
    }
}

