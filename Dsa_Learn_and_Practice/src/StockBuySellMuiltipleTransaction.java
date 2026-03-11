import java.util.*;
public class StockBuySellMuiltipleTransaction {
    public static int maximumProfit(int arr[]) {
        // code here
        List<Integer> a1 = new ArrayList<>(List.of(arr[0]));
        List<Integer> a2 = new ArrayList<>(List.of(arr[arr.length-1]));
        for(int i=1,j=arr.length-2;j>=0;i++,j--){
            if(arr[i]<arr[i-1])a1.add(arr[i]);
            if(arr[j]>arr[j+1])a2.add(0,arr[j]);
        }
        int sum=0;
        for(int i=0;i<a1.size();i++)
            sum+=a2.get(i)-a1.get(i);
        return sum;
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
