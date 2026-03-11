import java.util.*;
public class MaximiseNoof1s {
  static public int maxOnes(int arr[], int k) {
        // code here
        int kcount=0;
        int max=0;
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)kcount++;
            if(kcount>k) {
                for (; j <= i && kcount > k; j++) {
                    kcount -= arr[j] == 0 ? 1 : 0;
                }
            }
            max=Math.max(max,i+1-j);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++)arr[i]=sc.nextInt();
        System.out.println("Enter the k no of zeros ");
        int k = sc.nextInt();
        System.out.println(MaximiseNoof1s.maxOnes(arr,k));
    }
}
