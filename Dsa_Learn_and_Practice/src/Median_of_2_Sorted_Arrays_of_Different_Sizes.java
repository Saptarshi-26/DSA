import java.util.Scanner;
import java.util.stream.IntStream;

public class Median_of_2_Sorted_Arrays_of_Different_Sizes {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int[] merge = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length || j < b.length) {
            if (a.length == 0 || i == a.length) {
                merge[k++] = b[j++];
                continue;
            }
            if (b.length == 0 || i == b.length) {
                merge[k++] = a[j++];
                continue;
            }
            if (a[i] <= b[j]) {
                merge[k++] = a[i++];
            } else {
                merge[k++] = b[j++];
            }
        }
        int mid = merge.length / 2;
        if (merge.length % 2 == 0) return (double) (merge[mid] + merge[mid - 1]) / 2;
        return merge[mid];
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the first array ");
        int[] a = new int[sc.nextInt()];
        System.out.println("enter the length of the second array ");
        int[] b = new int[sc.nextInt()];
        System.out.println("enter the elements of the first array ");
        IntStream.range(0, a.length).forEach(i -> a[i] = sc.nextInt());
        System.out.println("enter the elements of the second array ");
        IntStream.range(0, b.length).forEach(i -> b[i] = sc.nextInt());
        System.out.println(new Median_of_2_Sorted_Arrays_of_Different_Sizes().findMedianSortedArrays(a, b));
    }
}
