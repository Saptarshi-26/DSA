import java.util.*;
public class Mincost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array");;
        int n= sc.nextInt();
        System.out.println("enter the element of the array");
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        long sum=0;
        long sum1=0;
        for(int i=0;i<n;i++){
            if(arr[i]%2==0)sum+=(long)arr[i];
            else sum1+=(long)arr[i];
        }
        if(sum<sum1) System.out.println(sum);
        else System.out.println(sum1);


    }
}
