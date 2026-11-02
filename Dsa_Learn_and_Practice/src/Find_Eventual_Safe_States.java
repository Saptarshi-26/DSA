import java.util.*;

public class Find_Eventual_Safe_States {
    public List<Integer> safe(HashMap<Integer, HashSet<Integer>> graphMap, HashMap<Integer, HashSet<Integer>> reverseMap, HashSet<Integer> safeSet, HashSet<Integer> currentSafe) {

        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> nextSafe = new HashSet<>();

        for (int safe : currentSafe) {
            if (!reverseMap.containsKey(safe)) continue;
            for (int from : reverseMap.get(safe)) {
                int count = graphMap.get(from).size();
                for (int to : graphMap.get(from)) {
                    if (!safeSet.contains(to)) break;
                    count--;
                }
                if (count == 0) {
                    safeSet.add(from);
                    nextSafe.add(from);
                }
            }
        }
        if (!nextSafe.isEmpty()) {
            ans.addAll(safe(graphMap, reverseMap, safeSet, nextSafe));
        }
        ans.addAll(currentSafe);
        return ans;

    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer, HashSet<Integer>> graphMap = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> reverseMap = new HashMap<>();
        HashSet<Integer> terminals = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            graphMap.put(i, new HashSet<>());
            for (int j = 0; j < graph[i].length; j++) {
                graphMap.get(i).add(graph[i][j]);
                if (reverseMap.containsKey(graph[i][j])) {
                    reverseMap.get(graph[i][j]).add(i);
                } else {
                    reverseMap.put(graph[i][j], new HashSet<>(Set.of(i)));
                }
            }
            if (graphMap.get(i).isEmpty()) terminals.add(i);

        }
        HashSet<Integer> safeSet = new HashSet<>(terminals);
        List<Integer> ans = new ArrayList<>(new HashSet<>(safe(graphMap, reverseMap, safeSet, terminals)));
        Collections.sort(ans);
        return ans;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of states ");
        int[][] graph = new int[sc.nextInt()][];
        for (int i = 0; i < graph.length; i++) {
            System.out.println("enter no of states from " + i);
            graph[i] = new int[sc.nextInt()];
            System.out.println("enter the states from " + i);
            for (int j = 0; j < graph[i].length; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.println(new Find_Eventual_Safe_States().eventualSafeNodes(graph));
    }
}
