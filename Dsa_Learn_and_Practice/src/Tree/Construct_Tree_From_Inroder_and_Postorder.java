package Tree;

import java.util.HashMap;

public class Construct_Tree_From_Inroder_and_Postorder {
    public static Node constree(HashMap<Integer, Integer> h, int[] ind, int[] post, int[] in) {
        Node n = new Node(post[ind[0]]);
        int index = h.get(post[ind[0]]);
        h.remove(post[ind[0]]);
        ind[0]--;

        if (index != in.length - 1 && h.containsKey(in[index + 1])) {
            n.right = constree(h, ind, post, in);
        }
        if (index != 0 && h.containsKey(in[index - 1])) {
            n.left = constree(h, ind, post, in);
        }
        return n;
    }

    public static Node buildTree(int[] in, int[] post) {
        // code here
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            h.put(in[i], i);
        }
        return constree(h, new int[]{in.length - 1}, post, in);

    }

}
