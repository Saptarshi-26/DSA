import java.util.*;
public class CountPairsWithGivenSum {
   static int countPairs(int arr[], int t) {
        // Your code here
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int x:arr)
            h.put(x,h.containsKey(x)?h.get(x)+1:1);
        double c=0;
        for(int x:arr)
            c+=h.containsKey(t-x)? (x!=(t-x))?(double) h.get(t - x) /2:(((double) h.get(t - x) -1)/2):0;
        return (int)c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println("Enter the target sum");
        System.out.println(countPairs(arr, sc.nextInt()));
    }
}
