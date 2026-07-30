package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Burning_Tree_1 {

    public int timeToBurn(List<Integer> nodes, HashMap<Integer,
            List<Integer>> map, HashSet<Integer> burnt) {

        List<Integer> nextBranches = new ArrayList<>();
        boolean visited = false;
        for (int x : nodes) {
            if (!burnt.contains(x)) {
                burnt.add(x);
                visited = true;
                nextBranches.addAll(map.get(x).stream().
                        filter(val -> !burnt.contains(val)).toList());
            }
        }
        if (visited) {
            return timeToBurn(nextBranches, map, burnt) + 1;
        }
        return 0;

    }

    public void doMap(Node currentNode, Node parent, HashMap<Integer, List<Integer>> map) {
        if (currentNode.left == null && currentNode.right == null) {
            map.put(currentNode.data, new ArrayList<>());
            if (parent != null) map.get(currentNode.data).add(parent.data);
        }

        List<Integer> parentsChild = new ArrayList<>();
        if (parent != null) parentsChild.add(parent.data);
        if (currentNode.left != null) {
            // int temp = currentNode.left.data;
            parentsChild.add(currentNode.left.data);
            doMap(currentNode.left, currentNode, map);
        }
        if (currentNode.right != null) {
            parentsChild.add(currentNode.right.data);
            doMap(currentNode.right, currentNode, map);
        }
        map.put(currentNode.data, parentsChild);
    }

    public int minTime(Node root, int target) {
        // code here
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        doMap(root, null, map);
        HashSet<Integer> burnt = new HashSet<>();
        burnt.add(target);
        return timeToBurn(map.get(target), map, burnt);


    }

}
