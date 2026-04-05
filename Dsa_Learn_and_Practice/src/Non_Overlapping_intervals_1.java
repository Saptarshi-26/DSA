import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Non_Overlapping_intervals_1 {
    public static int eraseOverlapIntervals(int[][] arr) {

       Arrays.sort(arr,(a,b)->a[1]-b[1]);
        int max = 1;
        int i=0;
        for (int j=1;j<arr.length;j++){
            if(arr[j][0]>=arr[i][1]){
                i=j;
                max++;
            }
        }
        return arr.length - max;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[][] arr = new int[sc.nextInt()][2];
        System.out.println("ënter the intervals ");
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        System.out.println(eraseOverlapIntervals(arr));
    }
}
