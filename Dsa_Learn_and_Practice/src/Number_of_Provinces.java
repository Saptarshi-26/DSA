import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Number_of_Provinces {
    public void visited(HashSet<Integer> set, HashSet<Integer> visited,
                        HashMap<Integer, HashSet<Integer>> map) {

        HashSet<Integer> nextSet = new HashSet<>();

        for (Integer i : set) {
            visited.add(i);
            if (map.containsKey(i)) {
                for (Integer j : map.get(i)) {
                    if (!visited.contains(j)) {
                        nextSet.add(j);
                    }
                }
            }
        }

        if (!nextSet.isEmpty()) visited(nextSet, visited, map);
    }

    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    if (!graph.containsKey(i)) {
                        graph.put(i, new HashSet<>());
                    }
                    graph.get(i).add(j);
                }
            }
        }
        int count = 0;
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                count++;
                visited(graph.get(i), visited, graph);
            }
        }
        return count;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of cities ");
        int[][] isConnected = new int[sc.nextInt()][];
        System.out.println("enter the connected cities ");
        for (int i = 0; i < isConnected.length; i++) {
            isConnected[i] = new int[isConnected.length];
            for (int j = 0; j < isConnected[i].length; j++) {
                isConnected[i][j] = sc.nextInt();
            }
        }
        System.out.println(new Number_of_Provinces().findCircleNum(isConnected));
    }
}
