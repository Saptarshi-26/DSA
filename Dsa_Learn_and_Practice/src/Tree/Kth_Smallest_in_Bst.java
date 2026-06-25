package Tree;

public class Kth_Smallest_in_Bst {
    public int KthSmallestHelper(Node n, boolean[] found, int ith, int k, int[] count) {

        count[0]++;

        int temp = ith;

        if (n.left != null) {
            temp = KthSmallestHelper(n.left, found, ith, k, count);
            if (found[0]) return temp;
            temp++;
        }


        if (temp == k) {
            found[0] = true;
            return n.data;
        }

        if (n.right != null) {
            temp = KthSmallestHelper(n.right, found, temp + 1, k, count);
            if (found[0]) return temp;
        }

        return temp;


    }

    public int kthSmallest(Node root, int k) {
        // code here
        int[] count = new int[1];
        int ans = KthSmallestHelper(root, new boolean[]{false}, 1, k, count);
        if (k > count[0]) return -1;
        return ans;
    }
}
