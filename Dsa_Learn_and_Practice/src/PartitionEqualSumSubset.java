import java.util.*;
public class PartitionEqualSumSubset {
    static boolean equalPartition(int arr[]) {
        // code here
        HashSet<Integer> h = new HashSet<>();
        int sum=0;
        for(int x:arr)sum+=x;
        for(int x:arr){
            if(sum-x==x)return true;
            HashSet<Integer> temp = new HashSet<>();
            for(int val:h){
                if(sum-(x+val)==(x+val))return true;
                temp.add(x+val);
            }
            h.addAll(temp);
            h.add(x);
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println(equalPartition(arr));
    }
}
