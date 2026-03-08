package Tree;

import java.util.*;

public class Construct_Tree_from_Pre_and_Post_Order {
    public static Node tree(int[] pr, int[] post, int i, int j,
                            HashMap<Integer, Integer> h, HashMap<Integer, Integer> h1, int val) {
        Node newNode = new Node(val);
        if (i < pr.length - 1 && j > 0) {
            if (pr[i + 1] != -1 && post[j - 1] != -1) {
                i++;
                j--;
                if (pr[i] == post[j]) {
                    int v1 = pr[i];
                    pr[i] = -1;
                    post[j] = -1;
                    newNode.left = tree(pr, post, i, j, h, h1, v1);
                } else {
                    int v1 = pr[i];
                    int v2 = post[j];
                    pr[i] = -1;
                    post[h1.get(v1)] = -1;
                    post[j] = -1;
                    pr[h.get(v2)] = -1;
                    newNode.left = tree(pr, post, h.get(v1), h1.get(v1), h, h1, v1);
                    newNode.right = tree(pr, post, h.get(v2), h1.get(v2), h, h1, v2);
                }
            }
        }
        return newNode;

    }

    public static Node constructTree(int[] pr, int[] post) {
        // code here
        HashMap<Integer, Integer> h = new HashMap<>();
        HashMap<Integer, Integer> h1 = new HashMap<>();
        for (int i = 0; i < pr.length; i++)
            h.put(pr[i], i);
        for (int i = 0; i < post.length; i++)
            h1.put(post[i], i);
        int v = pr[0];
        pr[0] = -1;
        post[post.length - 1] = -1;
        return tree(pr, post, 0, post.length - 1, h, h1, v);


    }
}
