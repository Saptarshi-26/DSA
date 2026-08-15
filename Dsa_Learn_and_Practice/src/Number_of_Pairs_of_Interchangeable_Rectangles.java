import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Number_of_Pairs_of_Interchangeable_Rectangles {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> ratioMap = new HashMap<>();
        long count = 0;
        for (int[] arr : rectangles) {
            double ratio = (double) arr[1] / arr[0];
            boolean isContain = ratioMap.containsKey(ratio);
            count += isContain ? ratioMap.get(ratio) : 0;
            ratioMap.put(ratio, isContain ? ratioMap.get(ratio) + 1 : 1);
        }
        return count;

    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of rectangles");
        int[][] rectangles = new int[sc.nextInt()][2];
        System.out.println("enter the rectangles ");
        IntStream.range(0, rectangles.length).
                forEach(i -> {
                    rectangles[i][0] = sc.nextInt();
                    rectangles[i][1] = sc.nextInt();
                });
        System.out.println(new Number_of_Pairs_of_Interchangeable_Rectangles().
                interchangeableRectangles(rectangles));

    }
}
