package Tree;

public class House_Robber_III {
    public int[] max(Node n) {
        if (n == null) return new int[]{0, 0};
        int[] left = max(n.left);
        int[] right = max(n.right);
        return new int[]{left[1] + right[1] + n.data,
                Math.max(left[0] + left[1],
                        Math.max(left[0] + right[1],
                                Math.max(left[1] + right[0], left[1] + right[1])))};

    }

    public int rob(Node root) {
        int[] ans = max(root);
        return Math.max(ans[0], ans[1]);
    }
}
