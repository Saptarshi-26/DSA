package Tree;

import java.util.*;

public class Construct_Tree_From_Inroder_and_Preorder {
    public static Node constree(HashMap<Integer, Integer> h, int[] ind, int[] pr, int[] in) {
        Node n = new Node(pr[ind[0]]);
        int index = h.get(pr[ind[0]]);
        h.remove(pr[ind[0]]);
        ind[0]++;
        if (index != 0 && h.containsKey(in[index - 1])) {
            n.left = constree(h, ind, pr, in);
        }
        if (index != in.length - 1 && h.containsKey(in[index + 1])) {
            n.right = constree(h, ind, pr, in);
        }
        return n;
    }

    public static Node buildTree(int[] in, int[] pr) {
        // code here
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            h.put(in[i], i);
        }
        return constree(h, new int[]{0}, pr, in);

    }

}
