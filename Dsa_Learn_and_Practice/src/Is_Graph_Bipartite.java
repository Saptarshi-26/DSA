import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Is_Graph_Bipartite {
    public boolean check(HashMap<Integer, Set<Integer>> map,
                         Set<Integer> currentLayer, HashMap<Integer,
                    Set<Integer>> grpMap, HashSet<Integer> uniSet, int grp) {

        if (currentLayer.isEmpty()) return true;
        Set<Integer> nextLayer = new HashSet<>();
        for (int x : currentLayer) {
            grpMap.get(grp).add(x);
            uniSet.add(x);
            if (!map.containsKey(x)) continue;
            for (int branch : map.get(x)) {
                if (!uniSet.contains(branch)) nextLayer.add(branch);
                else {
                    if (grpMap.get(grp).contains(branch)) return false;
                }
            }
        }
        return check(map, nextLayer, grpMap, uniSet, grp == 0 ? 1 : 0);
    }

    public boolean isBipartite(int[][] graph) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            map.put(i, new HashSet<>());
            // System.out.println(map);
            for (int j = 0; j < graph[i].length; j++) {
                map.get(i).add(graph[i][j]);
            }
        }
        HashMap<Integer, Set<Integer>> grpMap = new HashMap<>();
        grpMap.put(0, new HashSet<>());
        grpMap.put(1, new HashSet<>());
        HashSet<Integer> uniSet = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (!map.get(i).isEmpty()) {
                if (uniSet.contains(i)) continue;
                if (!check(map, new HashSet<>(Set.of(i)), grpMap, uniSet, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of nodes in graph ");
        int[][] graph = new int[sc.nextInt()][];
        System.out.println("enter the no of edges in graph ");
        for (int i = 0; i < graph.length; i++) {
            System.out.println("enter how many edges from node " + i);
            graph[i] = new int[sc.nextInt()];
            System.out.println("enter the edges form Node " + i);
            for (int j = 0; j < graph[i].length; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.println(new Is_Graph_Bipartite().isBipartite(graph));
    }
}
