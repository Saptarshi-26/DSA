import java.util.*;
import java.util.stream.Collectors;

public class Network_Delay_Time {
    public void minTime(HashMap<Integer,List<int[]>> map,HashMap<Integer,Integer> minTime,
                        HashSet<Integer> loop,List<int[]> currentBranch, int totalTime ){

        for (int[] arr : currentBranch){

            if(!loop.contains(arr[1])){

                if(map.containsKey(arr[1]) &&
                        ((!minTime.containsKey(arr[1]))||(minTime.get(arr[1])>totalTime+arr[2])) ){

                    loop.add(arr[1]);

                    minTime(map,minTime,loop,map.get(arr[1]),totalTime + arr[2]);

                    loop.remove(arr[1]);
                }
                minTime.put(arr[1],minTime.containsKey(arr[1])?
                        Math.min(minTime.get(arr[1]),totalTime+arr[2]):totalTime+arr[2]);

            }
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {

        HashMap<Integer, List<int[]>> map =
                Arrays.stream(times).collect(Collectors.
                        groupingBy(x->x[0],HashMap::new ,Collectors.toList()));

        if(!map.containsKey(k))return -1;

        HashMap<Integer,Integer> minTime = new HashMap<>(Map.of(k,0));

        minTime(map,minTime,new HashSet<>(Set.of(k)),map.get(k),0);

        if(minTime.size()<n)return -1;

        return minTime.get(minTime.keySet().stream().max(Comparator.comparingInt(minTime::get)).get());
    }
    static void main() {

        Scanner sc= new Scanner(System.in);

        System.out.println("enter the number of networks  ");

        int[][] times = new int[sc.nextInt()][3];

        System.out.println("enter the networks  \"[from , to , time ] \" ");

        for(int i=0;i<times.length;i++){

            for(int j=0;j<3;j++){

                times[i][j]=sc.nextInt();
            }
        }

        System.out.println("enter the total no of networks ");
        int n = sc.nextInt();
        System.out.println("enter the starting network ");
        int k = sc.nextInt();

        System.out.println(new Network_Delay_Time().networkDelayTime(times,n,k));
    }
}
