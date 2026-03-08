package Tree;

public class Flatten_Binary_Tree_into_LinkedList {
    Node b_tree_to_dll(Node n) {
        // code here
        if (n.left == null && n.right == null) return n;

        Node left = n.left != null ? b_tree_to_dll(n.left) : null;
        Node right = n.right != null ? b_tree_to_dll(n.right) : null;

        n.left = null;
        n.right = null;
        Node temp = n;
        if (left != null) {
            n.right = left;
            temp = left;
            while (temp.right != null) temp = temp.right;
        }

        if (right != null) {
            temp.right = right;
        }

        return n;
    }

    public void flatten(Node n) {
        if (n == null) {
            return;
        }
        b_tree_to_dll(n);

    }
}
