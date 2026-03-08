package Tree;

public class Binary_Tree_to_DLL {
    Node b_tree_to_dll(Node n, int dir) {
        // code here
        if (n.left == null && n.right == null) return n;
        Node left = n.left != null ? b_tree_to_dll(n.left, 0) : null;
        Node right = n.right != null ? b_tree_to_dll(n.right, 1) : null;
        n.left = null;
        n.right = null;
        if (left != null) {
            left.right = n;
            n.left = left;
        }
        if (right != null) {
            n.right = right;
            right.left = n;
        }
        if (dir == 1) while (n.left != null) n = n.left;
        else while (n.right != null) n = n.right;
        return n;
    }

    Node bToDLL(Node n) {
        // code here
        return b_tree_to_dll(n, 1);
    }
}
