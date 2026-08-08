import java.util.ArrayList;
import java.util.Scanner;

public class Sum_Sub_array_Minimum {
    static public int sumSubarrayMins(int[] arr) {

        ArrayList<Integer> sub_arr_min = new ArrayList<>();

        long ans =0;
        long  mod = 1000000007l;
        for (int i=arr.length-1;i>=0;i--){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int x : sub_arr_min){
                ans = (ans+Math.min(arr[i],x))%mod;
                temp.add(Math.min(arr[i],x));
            }
            sub_arr_min = temp;
            sub_arr_min.add(arr[i]);
            ans+=arr[i]%mod;
        }

        return (int)ans;



    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(sumSubarrayMins(arr));
    }
}
