import java.util.Scanner;
//this program is to find the second largest element in the array
public class SecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("enter the element in the array ");
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }

        int t=arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]<t)t=arr[i];
        }
        int tt=t;

        for(int i=0;i<n;i++){
            if(arr[i]>t){
                tt=t;
                t=arr[i];
            }
            else if(arr[i]>tt&&arr[i]!=t){
                tt=arr[i];
            }
        }
        System.out.println(tt);
    }
}
