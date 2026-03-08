import java.util.*;
public class SortedandRotatedMinimum {
    public static int findMin(int[] arr) {
        // complete the function here
        if(arr.length==2)return Math.min(arr[0],arr[1]);
        int i=0;
        int j=arr.length-1;
        int mid=j/2;
        while(i<=j){
          //  if(mid==0||mid==arr.length-1) return arr[mid];
            if(i+1==j)return Math.min(arr[i],arr[j]);
            if(arr[mid]<arr[mid-1])return arr[mid];
            if(arr[i]>arr[j]){
                if(arr[mid]>=arr[i]){
                    i=mid+1;
                }
                else{
                    j=mid-1;
                }
                mid=(i+j)/2;
            }
            else return arr[i];

        }
        return arr[mid];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        System.out.println(findMin(arr));
    }
}
