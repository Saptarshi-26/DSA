package Tree;

public class Distribute_Candy_in_a_Binary_tree {
    public static int[] candy(Node n, int[] count) {

        //ans[0] is for extra
        //ans[1] is fpr empty

        int[] ans = new int[2];

        if (n.left == null && n.right == null) {
            if (n.data > 1) ans[0] = n.data - 1;
            else if (n.data == 0) ans[1] = 1;
            return ans;
        }

        int[] left = n.left != null ? candy(n.left, count) : new int[2];
        int[] right = n.right != null ? candy(n.right, count) : new int[2];

        // count is for counting the answer

        count[0] += left[1];
        count[0] += right[1];
        count[0] += left[0] + right[0];

        ans[0] = left[0] + right[0] + (n.data > 1 ? n.data - 1 : 0);
        ans[1] = left[1] + right[1] + (n.data == 0 ? 1 : 0);

        if (ans[0] >= ans[1]) {
            ans[0] -= ans[1];
            ans[1] = 0;

        } else {
            ans[1] -= ans[0];
            ans[0] = 0;
        }

        return ans;


    }

    public static int distributeCandy(Node root) {
        // code here
        int[] count = new int[1];
        candy(root, count);
        return count[0];
    }
}