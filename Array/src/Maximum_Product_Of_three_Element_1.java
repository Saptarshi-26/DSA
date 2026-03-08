import java.util.*;
public class Maximum_Product_Of_three_Element {
    public static long maxProduct(int[] arr) {
        long ans =0;
        if(arr.length<3)return ans;
        Arrays.sort(arr);
        long a1 = (long) arr[arr.length - 1] *arr[arr.length-2];
        long a2 = (long) arr[0] *arr[1];
        ans = Math.max(Math.abs(a1),Math.abs(a2));
        ans = ans*(long)Math.pow(10,5);
        return ans ;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for ( int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        System.out.println(maxProduct(arr));

    }
}
