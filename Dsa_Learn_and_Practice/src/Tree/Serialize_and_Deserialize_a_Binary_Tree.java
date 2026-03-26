package Tree;

import java.util.ArrayList;
import java.util.List;

public class Serialize_and_Deserialize_a_Binary_Tree {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return "null";
        String ans = Integer.toString(root.data);
        String temp = "";
        ArrayList<Node> node = new ArrayList<>(List.of(root));
        while (!node.isEmpty()) {
            temp = "";
            int flag = 0;
            ArrayList<Node> node1 = new ArrayList<>();
            for (Node x : node) {
                if (x.left != null) {
                    temp += " " + x.left.data;
                    flag = 1;
                    node1.add(x.left);
                } else temp += " " + "null";
                if (x.right != null) {
                    temp += " " + x.right.data;
                    flag = 1;
                    node1.add(x.right);
                } else temp += " " + "null";

            }
            node = node1;
            if (flag == 1) ans += temp;
        }
        return ans;

    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] node = data.split(" ");
        if (node[0].equals("null")) return null;
        ArrayList<Node> tree = new ArrayList<>(List.of(new Node(Integer.parseInt(node[0]))));
        Node ans = tree.getFirst();
        int i = 1;
        while (i < node.length) {
            ArrayList<Node> tree1 = new ArrayList<>();
            for (int k = 0; k < tree.size() && i < node.length; k++, i++) {
                Node n1, n2;
                if (!node[i].equals("null")) {
                    n1 = new Node(Integer.parseInt(node[i]));
                    tree.get(k).left = n1;
                    tree1.add(n1);
                }
                i++;
                if (i >= node.length) break;
                if (!node[i].equals("null")) {
                    n2 = new Node(Integer.parseInt(node[i]));
                    tree.get(k).right = n2;
                    tree1.add(n2);
                }

            }
            tree = tree1;
        }
        return ans;

    }
}
