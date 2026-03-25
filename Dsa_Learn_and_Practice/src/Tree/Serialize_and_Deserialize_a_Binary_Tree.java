package Tree;

import java.util.ArrayList;
import java.util.List;

public class Serialize_and_Deserialize_a_Binary_Tree {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root==null)return "null";
        String ans =Integer.toString(root.data);
        ArrayList<Node> node = new ArrayList<>(List.of(root));
        while(!node.isEmpty()){
            ArrayList<Node> node1 = new ArrayList<>();
            for(Node x : node){
                if(x.left!=null){
                    ans+=" "+Integer.toString(x.left.data);
                    node1.add(x.left);
                }
                else ans+=" "+"null";
                if(x.right!=null){
                    ans+=" "+Integer.toString(x.right.data);
                    node1.add(x.right);
                }
                else ans+=" "+"null";

            }
            node = node1;
        }
        return ans;

    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] node = data.split(" ");
        int i=0;
        int node_per_layer=1;
        return null;

    }
}
