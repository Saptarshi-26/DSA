package Tree;
import java.util.*;
public class LowestCommonAncestor {
   static Node lca(Node n, int n1, int n2) {
        // Your code here
        if (n.left == null && n.right == null) {
            if (n.data == n1 || n.data == n2) return n;
            return null;
        }
        Node t = null, t1 = null;
        if (n.left != null) t = lca(n.left, n1, n2);
        if (n.right != null) t1 = lca(n.right, n1, n2);

        if (t != null && t1 != null) {
            return n;
        } else if (t != null) {
            if (n.data + t.data == n1 + n2 && (t.data == n1 || t.data == n2)) return n;
            return t;
        } else if (t1 != null) {
            if (n.data + t1.data == n1 + n2 && (t1.data == n1 || t1.data == n2)) return n;
            return t1;
        }

        if (n.data == n1 || n.data == n2) return n;
        return null;

    }
}
