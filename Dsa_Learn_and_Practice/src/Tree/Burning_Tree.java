package Tree;

import java.util.HashSet;

public class Burning_Tree {

    public int timetoBurn(Node n, Node parent, HashSet<Integer> burnt,
                          int target) {

        if (n == null) return 0;
        int sec = 0;
        if (n.data == target) {
            sec++;
            burnt.add(n.data);
            burnt.add(parent.data);
            if (n.left != null) burnt.add(n.left.data);
            if (n.right != null) burnt.add(n.right.data);

        }

        if (burnt.contains(parent.data) && !burnt.contains(n.data)) {
            sec++;
            burnt.add(n.data);
            if (n.left != null) burnt.add(n.left.data);
            if (n.right != null) burnt.add(n.right.data);
        }

        sec += timetoBurn(n.left, n, burnt, target);
        if (n.left != null && burnt.contains(n.left.data)) {
            if (!burnt.contains(n.data)) {
                sec++;
                burnt.add(n.data);
                burnt.add(parent.data);
                if (n.right != null) burnt.add(n.right.data);
            }

        }
        sec += timetoBurn(n.right, n, burnt, target);
        if (n.right != null && burnt.contains(n.right.data)) {
            if (!burnt.contains(n.data)) {
                sec++;
                burnt.add(n.data);
                burnt.add(parent.data);
                if (n.left != null) {
                    burnt.add(n.left.data);
                    sec += timetoBurn(n.left, n, burnt, target);
                }
            }
        }
        return sec;


    }

    public int minTime(Node root, int target) {
        // code here
        return timetoBurn(root, root, new HashSet<>(), target);

    }

}
