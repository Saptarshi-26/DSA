package Tree;

import java.util.*;

public class Normal_BST_To_Balanced_BST {
    ArrayList<Node> toarr(Node n) {
        if (n == null) return new ArrayList<>();
        ArrayList<Node> arr = new ArrayList<>(toarr(n.left));
        arr.add(n);
        arr.addAll(toarr(n.right));
        return arr;
    }

    Node balance(ArrayList<Node> arr, int i, int j) {
        if (i + 1 == j) {
            arr.get(i).right = arr.get(j);
            arr.get(i).left = null;
            arr.get(j).right = arr.get(j).left = null;
            return arr.get(i);
        }
        if (i == j) {
            arr.get(i).right = null;
            arr.get(i).left = null;
            return arr.get(i);
        }
        int mid = (i + j) / 2;
        arr.get(mid).left = balance(arr, i, mid - 1);
        arr.get(mid).right = balance(arr, mid + 1, j);
        return arr.get(mid);

    }

    Node balanceBST(Node root) {
        // Add your code here.
        ArrayList<Node> arr = new ArrayList<>(toarr(root));
        return balance(arr, 0, arr.size() - 1);

    }
}
