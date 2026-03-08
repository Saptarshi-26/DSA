import java.util.*;
public class Min_Subset_with_Consecutive_Numbers {
   static int c(int [] arr, int i){
        for(;i<arr.length-1;i++){
            if(arr[i]+1!=arr[i+1])break;
        }
        return i+1;
    }
   static public int numOfSubset(int[] arr) {
        // Your code goes here
        Arrays.sort(arr);
        int c=0;
        int i=0;
        while(i<arr.length){
            i=c(arr,i);
            c++;
        }
        return c;
    }
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int [] arr = new int[sc.nextInt()];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<arr.length;i++)arr[i]=sc.nextInt();
       System.out.println(numOfSubset(arr));
    }
}
