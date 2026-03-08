import java.util.*;
public class StockBuySingleTransaction {
    public static int maximumProfit(int arr[]) {
        // Code here
        int a[]= new int [arr.length];
        int max=arr[arr.length-1];
        for(int i=arr.length-1;i>=0;i--){
            if(max<arr[i])max=arr[i];
            a[i]=max;
        }
        max=a[0]-arr[0];
        for(int i=0;i<arr.length;i++){
            if(a[i]-arr[i]>max)max=a[i]-arr[i];
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println(maximumProfit(arr));

    }
}
