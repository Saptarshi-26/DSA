package Tree;
import java.util.*;
public class TopView {
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(root.data);
        ArrayList<ArrayList<Node>> node = new ArrayList<>();
        ArrayList<Node> t = new ArrayList<>();
        t.add(root);
        t.add(new Node(0));
        node.add(t);
        int max = 0;
        int min = Integer.MAX_VALUE;

        while (!node.isEmpty()) {
            ArrayList<ArrayList<Node>> temp = new ArrayList<>();

            for (ArrayList<Node> nodes : node) {
                ArrayList<Node> temp1 = new ArrayList<>();

                if (nodes.get(0).left != null) {
                    temp1.add(nodes.get(0).left);
                    int data = nodes.get(1).data + 1;
                    temp1.add(new Node(data));
                    if (data > max) {
                        ans.addFirst(nodes.getFirst().left.data);
                        max = data;
                    }
                    temp.add(temp1);
                }

                temp1 = new ArrayList<>();
                if (nodes.get(0).right != null) {
                    temp1.add(nodes.get(0).right);
                    int data = nodes.get(1).data - 1;
                    temp1.add(new Node(data));
                    if (data < min && data < 0) {
                        ans.add(nodes.getFirst().right.data);
                        min = data;
                    }
                    temp.add(temp1);
                }
            }

            node = temp;
        }
        System.out.println(ans);
        return ans;
    }

}
