package Tree;
import java.util.*;
public class ConectNodesOfLeaves {
    public static void conct(ArrayList<Node > arr){
        ArrayList<Node> a = new ArrayList<>();
        for (Node node : arr) {
            if (node.left != null) {
                a.add(node.left);
                if (a.size() > 1) {
                    a.get(a.size() - 2).nextRight = a.getLast();
                }
                a.getLast().nextRight = null;

            }
            if (node.right != null) {
                a.add(node.right);
                if (a.size() > 1) {
                    a.get(a.size() - 2).nextRight = a.get(a.size() - 1);
                }
                a.getLast().nextRight = null;

            }
        }
        if(!a.isEmpty())conct(a);
    }

    public static Node connect(Node root) {
        // Your code goes here.
        conct(new ArrayList<>(List.of(root)));
        return root;
    }
}
