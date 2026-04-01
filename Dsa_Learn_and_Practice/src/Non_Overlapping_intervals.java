import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Non_Overlapping_intervals {
    public static int eraseOverlapIntervals(int[][] arr) {

       TreeMap<Integer,int[]> sort_map = Arrays.stream(arr).collect(Collectors.toMap(x -> x[0],
               Function.identity(), BinaryOperator.minBy((a, b) -> a[1] - b[1]), TreeMap::new));

       List<int[]> intervals = sort_map.keySet().stream().map(sort_map::get).toList();

       HashMap<int[] ,Integer > min_chain = new HashMap<>(Map.of(intervals.getFirst(),1));

       intervals.forEach(x->System.out.println(Arrays.toString(x)));


       








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
