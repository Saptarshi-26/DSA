package Tree;


import java.util.HashSet;
import java.util.Set;

public class Cousin_In_Binary_Tree {
    public boolean cousin(HashSet<Node> h, int x, int y) {
        if (h.isEmpty()) return false;
        int c = 0;
        HashSet<Node> h1 = new HashSet<>();
        for (Node i : h) {
            if (i.left != null) {
                h1.add(i.left);
            }
            if (i.right != null) {
                h1.add(i.right);
            }
            if ((i.left != null && (i.left.data == x || i.left.data == y)) ||
                    (i.right != null && (i.right.data == x || i.right.data == y))) {
                c++;
            }

        }

        return c == 2 || cousin(h1, x, y);


    }

    public boolean isCousins(Node root, int x, int y) {
        return cousin(new HashSet<>(Set.of(root)), x, y);
    }
}
