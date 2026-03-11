import java.lang.foreign.MemorySegment;
import java.util.*;
public class SubarraySunEqualK {
    public static int subarraySum(int[] arr, int k) {
      HashMap<Integer,Integer> h = new HashMap<>();
      int c=0;
      int sum=0;
        for (int j : arr) {
            sum += j;
            if(sum==k)c++;
            if (h.containsKey(sum - k)) c += h.get(sum - k);
            if (!h.containsKey(sum)) h.put(sum, 1);
            else h.put(sum, h.get(sum) + 1);
        }
      return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println("Enter the sum ");
        int k= sc.nextInt();
        System.out.println(subarraySum(arr,k));
    }
}
