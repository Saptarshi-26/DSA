import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Minimize_Max_Distance_of_Adjacent_Gas_Stations {

    public int reduce(TreeMap<Double, PriorityQueue<Double>> gap, int k) {
        double maxKey = gap.keySet().stream().findFirst().get();
        double pollVal = gap.get(maxKey).poll();
        int count = 0;
        double nextMax = maxKey;
        if (gap.get(maxKey).isEmpty()) {
            gap.remove(maxKey);
            for (double key : gap.keySet()) {
                count++;
                if (key < maxKey || count == 2) {
                    nextMax = key;
                    break;
                }
            }
        }

        while (maxKey >= nextMax && k > 0) {
            k--;
            maxKey = pollVal / ((pollVal / maxKey) + 1);
            if (gap.containsKey(maxKey)) {
                gap.get(maxKey).add(pollVal);
                pollVal = gap.get(maxKey).poll();
            }
        }
        if (gap.containsKey(maxKey)) {
            gap.get(maxKey).add(pollVal);

        } else {
            PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
            pq.add(pollVal);
            gap.put(maxKey, pq);
        }
        return k;

    }


    public double minMaxDist(int[] stations, int k) {
        // code here
        if (stations.length <= 1) return 0;
        TreeMap<Double, PriorityQueue<Double>> gap = new TreeMap<>(
                (a, b) -> Double.compare(b, a));
        for (int i = 1; i < stations.length; i++) {
            double diff = stations[i] - stations[i - 1];
            if (gap.containsKey(diff)) {
                gap.get(diff).add(diff);
            } else {
                PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
                pq.add(diff);
                gap.put(diff, pq);
            }
        }
        while (k > 0) {
            k = reduce(gap, k);
        }
        return gap.keySet().stream().findFirst().get();
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of gas stations ");
        int[] stations = new int[sc.nextInt()];
        System.out.println("enter the gas stations ");
        IntStream.range(0, stations.length).forEach(i -> stations[i] = sc.nextInt());
        System.out.println("enter the no of gas stations to be added ");
        int k = sc.nextInt();
        System.out.println(new Minimize_Max_Distance_of_Adjacent_Gas_Stations().
                minMaxDist(stations, k));

    }
}
