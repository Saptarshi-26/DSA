import java.util.*;
public class Minjumps {
    static int  min(int[] arr , int i){
        if(i+arr[i]>=arr.length){
            return 1;
        }
        int min=-1;
        for(int j=i+1;j<arr.length&&j<=(i+arr[i]);j++){
            if(arr[j]==0)continue;
            int t=min(arr,j);
            if(t==-1)continue;
            t=t+1;
            if(min==-1){
                min=t;
            }
            else if(t<min)min=t;
        }
        return  min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int n= sc.nextInt();
        System.out.println("enter the elements of the array");
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]= sc.nextInt();
        int temp=min(arr,0);
        System.out.println(arr.length<=2?temp:temp-1);
    }
}
