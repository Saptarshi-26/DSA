import java.util.*;
public class LongestSubarraywuthsumk {
    public static int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> h = new HashMap<>(Map.of(arr[0],0));
        int c=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==k){
                c=i+1;continue;
            }
            if(!h.containsKey(sum)){
                h.put(sum,i);
            }
            if(h.containsKey(sum-k)){
                if(c<i-h.get(sum-k))c=i-h.get(sum-k);
            }
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
        System.out.println(longestSubarray(arr,k));
    }
}
