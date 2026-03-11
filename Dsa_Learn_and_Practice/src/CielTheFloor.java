import java.util.*;
public class CielTheFloor {
    public static int[] ceilfloor (int x , int[] arr){
        int a[]=new int[2];
        Arrays.sort(arr);
        int mid=(arr.length-1)/2;
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            if(arr[mid]==x)
                break;
            if(arr[mid]<x){
                i=mid+1;
                mid=(i+j)/2;
            }
            else{
                j=mid-1;
                mid=(i+j)/2;
            }

        }
        if(arr[mid]==x){
            a[0]=x;
            a[1]=x;
            return a ;
        }
        if(arr[mid]>x){
            a[1]=arr[mid];
            if(mid>0)a[0]=arr[mid-1];
            else a[0]=-1;
            return a;
        }
        a[0]=arr[mid];
        if(mid<arr.length-1)a[1]=arr[mid+1];
        else a[1]=-1;
        return a ;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array ");
        for (int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println("Enter the element you want to find ");
        int x = sc.nextInt();
       // Arrays.sort(arr);
        int a[]=new int[2];
        a=ceilfloor(x,arr);
        for (int value:a)
        System.out.print(value+" ");

    }
}
