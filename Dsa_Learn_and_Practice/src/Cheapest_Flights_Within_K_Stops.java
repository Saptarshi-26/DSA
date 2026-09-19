import java.util.*;
import java.util.stream.IntStream;

public class Cheapest_Flights_Within_K_Stops {

    public int cheapest(HashMap<Integer, List<int[]>> map,
                        HashMap<Integer, Integer> minDist,
                        int src, int dst, HashSet<Integer> visited, int k , int n) {

        int ans = Integer.MAX_VALUE;
        if (src == dst) {
            return minDist.get(src);
        }
       if(k==-1 && minDist.size()<n){
            minDist.remove(src);
            return ans ;
        }

        if (!map.containsKey(src) || visited.contains(src) ) return ans;

        visited.add(src);

        List<int[]> branches = map.get(src);

        for (int[] branch : branches) {
            if (!minDist.containsKey(branch[0]) ||
                    minDist.get(branch[0]) > minDist.get(src) + branch[1]) {

                minDist.put(branch[0], minDist.get(src) + branch[1]);
                ans = Math.min(ans, cheapest(map, minDist, branch[0], dst, visited,k-1,n));
                if(minDist.size()<n)minDist.remove(branch[0]);

            }
        }

        visited.remove(src);

        return ans;

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        HashMap<Integer,List<int[]>> map = new HashMap<>();
        HashMap<Integer, Integer> minDist = new HashMap<>();

        for (int[] arr : flights) {
            if (map.containsKey(arr[0])) {
                map.get(arr[0]).add(new int[]{arr[1], arr[2]});
            } else {
                List<int[]> pq = new ArrayList<>();
                pq.add(new int[]{arr[1], arr[2]});
                map.put(arr[0], pq);
            }
        }
        minDist.put(src, 0);

        int cheapestDist = cheapest(map,minDist,src,dst,new HashSet<>(),k,n);
        return cheapestDist==Integer.MAX_VALUE?-1:cheapestDist;

    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of flights ");
        int[][] flights = new int[sc.nextInt()][3];
        System.out.println("enter the from to and cost if each flight ");
        HashSet<Integer> uniqueFlights = new HashSet<>();
        IntStream.range(0, flights.length).forEach(i -> {
            flights[i][0] = sc.nextInt();
            flights[i][1] = sc.nextInt();
            flights[i][2] = sc.nextInt();
            uniqueFlights.add(flights[i][0]);
            uniqueFlights.add(flights[i][1]);
        });
        System.out.println("enter the no of steps allowed ");
        int k = sc.nextInt();
        System.out.println("enter the source ");
        int src = sc.nextInt();
        System.out.println("enter the destination ");
        int dst = sc.nextInt();

        System.out.println(new Cheapest_Flights_Within_K_Stops().
                findCheapestPrice(uniqueFlights.size(),flights,src,dst,k));

    }

}


