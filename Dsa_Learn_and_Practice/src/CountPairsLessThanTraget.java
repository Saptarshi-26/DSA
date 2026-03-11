import java.util.*;
public class CountPairsLessThanTraget {
    static int countPairs(int[] arr, int t) {
        // Your code here
        Arrays.sort(arr);
        int c=0;
        int i=0; int j=arr.length-1;
        while(i<j){
            if(arr[i]+arr[j]>=t)j--;
            else {
                c+=(j-i);
                i++;
            }
        }
        return c;
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
