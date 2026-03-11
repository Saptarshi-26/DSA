import java.util.*;
public class RotateArray {
    static void rotate(int[] arr, int i ,int j){
        while(i<j){
            int t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
            i++;j--;
        }
    }
    static void rotateArr(int arr[], int d) {
        // add your code here
        int n=arr.length;
        if(d>=n)d=d%n;
        if(d==0||arr.length==1)return;
        rotate(arr,0,d-1);
        rotate(arr,d,arr.length-1);
        rotate(arr,0,arr.length-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println("Enter the number of times the array is to be rotated");
        int d = sc.nextInt();
       rotateArr(arr,d);
        for(int x:arr)
            System.out.print(x+" ");
    }
}
