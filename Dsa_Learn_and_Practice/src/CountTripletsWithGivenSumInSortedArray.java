import java.util.*;
public class CountTripletsWithGivenSumInSortedArray {

    public static int countTriplets(int[] arr, int t) {
        // Code Here
        int c=0;
        for(int i=0;i<arr.length-2;i++){
            int x=i+1;
            int y=arr.length-1;
            int t1=t-arr[i];
            while(x<y){
                // int cx=0;
                // int cy=0;
                if(arr[x]+arr[y]<t1)x++;
                else if(arr[x]+arr[y]>t1)y--;
                else{

                    if(arr[x]==arr[y]){
                        int n=(y-x+1);c+=n*(n-1)/2;
                        break;
                    }
                    int cx=1;
                    int cy=1;
                    while(x+1<y&&arr[x]==arr[x+1]){
                        x++;cx++;
                    }
                    while(y-1>x&&arr[y]==arr[y-1]){
                        y--;
                        cy++;
                    }
                    c+=cx*cy;
                    x++;
                    y--;

                }
            }

        }
        return c;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int [] arr = new int [sc.nextInt()];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<arr.length;i++)arr[i]=sc.nextInt();
        System.out.println("Enter the target ");
        int target = sc.nextInt();
        System.out.println(countTriplets(arr,target));
    }
}
