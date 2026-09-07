import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Clone_Graph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node clone(Node n, HashMap<Node, Node> nodeHashMap) {
        if (nodeHashMap.containsKey(n)) {
            return nodeHashMap.get(n);
        }

        if (n != null) {
            Node newNode = new Node();
            newNode.val = n.val;
            nodeHashMap.put(n, newNode);
            List<Node> list = new ArrayList<>();
            for (Node node : n.neighbors) {
                Node n1 = clone(node, nodeHashMap);
                list.add(n1);
            }
            newNode.neighbors = list;

            return newNode;

        }
        return null;
    }

    public Node cloneGraph(Node node) {
        return clone(node, new HashMap<>());
    }

    static void printGraph(Node start) {
        if (start == null) {
            System.out.println("[]");
            return;
        }
        java.util.Map<Integer, Node> visited = new java.util.TreeMap<>();
        java.util.Deque<Node> queue = new java.util.ArrayDeque<>();
        queue.add(start);
        visited.put(start.val, start);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node nb : cur.neighbors) {
                if (!visited.containsKey(nb.val)) {
                    visited.put(nb.val, nb);
                    queue.add(nb);
                }
            }
        }
        StringBuilder sb = new StringBuilder("[");
        boolean first = true;
        for (Node n : visited.values()) {
            if (!first) sb.append(", ");
            first = false;
            List<Integer> vals = new ArrayList<>();
            for (Node nb : n.neighbors) vals.add(nb.val);
            java.util.Collections.sort(vals);
            sb.append(vals);
        }
        sb.append("]");
        System.out.println(sb);
    }

    static void main(String[] args) {
        // Build sample graph: adjList = [[2,4],[1,3],[2,4],[1,3]]
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        System.out.println("Original graph:");
        printGraph(n1);

        Clone_Graph solver = new Clone_Graph();
        Node cloned = solver.cloneGraph(n1);

        System.out.println("Cloned graph:");
        printGraph(cloned);

        // Sanity check: cloned root should be a different object than original root
        System.out.println("Same object as original? " + (cloned == n1));
    }
}