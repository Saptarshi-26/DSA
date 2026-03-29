import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Non_Overlapping_intervals {
    public static int eraseOverlapIntervals(int[][] arr) {
       TreeMap<Integer,int[]> map = Arrays.stream(arr).collect(Collectors.groupingBy(x->x[0], TreeMap::new,
               Collectors.collectingAndThen(Collectors.minBy((a,b)->a[1]-b[1]),a->a.get())));







//        for (int x : interval_sorted.keySet()){
//            for (int []i : interval_sorted.get(x))
//                System.out.println(i[0]+" "+i[1]);
//        }
      return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[][] arr = new int[sc.nextInt()][2];
        System.out.println("ënter the intervals ");
        for (int i=0;i<arr.length;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        eraseOverlapIntervals(arr);
    }
}
