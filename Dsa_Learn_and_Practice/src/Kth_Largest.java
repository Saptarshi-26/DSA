import java.util.PriorityQueue;
import java.util.Scanner;

public class Kth_Largest {
    public static int kthLargest(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : arr) {
            pq.add(x);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();

    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("enter value of k of which kth largest element to be found ");
        int k = sc.nextInt();
        System.out.println(kthLargest(arr, k));
    }
}
