package Tree;

public class AVL_Tree_Insertion {

    int height(Node n) {
        if (n.left == null && n.right == null) return 1;
        return Math.max(n.left != null ? height(n.left) + 1 : 0, n.right != null ? height(n.right) + 1 : 0);
    }
     void right_rotate(Node n){
        Node temp = new Node(n.data) ;
        temp.right=n.right;
        Node left_gchild = n.left.left;
        Node child_right = n.left.right;

        n.data=n.left.data;
        n.left=left_gchild;
        n.right=temp;

        temp.left=child_right;

     }
     void left_rotate(Node n){
         Node temp = new Node(n.data) ;
         temp.left=n.left;
         Node right_gchild = n.right.right;
         Node child_left= n.right.left;

         n.data=n.right.data;
         n.right=right_gchild;
         n.left=temp;

         temp.right=child_left;

     }
    int avl(Node n, int data) {
        if (data > n.data && n.right == null) {
            n.right = new Node(data);
            return 2;
        }
        if (data < n.data && n.left == null) {
            n.left = new Node(data);
            return 2;
        }
        if (data > n.data) {
            int height_right = avl(n.right, data);
            if (height_right == 0) return 0;
            int height_left = n.left != null ? height(n.left) : 0;
            if (Math.abs(height_left - height_right) <= 1)
                return Math.max(height_left, height_right) + 1;
            else {
                if (data > n.right.data) {
                    left_rotate(n);
                } else {
                    right_rotate(n.right);
                    left_rotate(n);
                }
                return 0;
            }

        } else {
            int height_left = avl(n.left, data);
            if (height_left == 0) return 0;
            int height_right = n.right != null ? height(n.right) : 0;
            if (Math.abs(height_left - height_right) <= 1)
                return Math.max(height_left, height_right) + 1;
            else {
                if (data < n.left.data) {
                    right_rotate(n);
                } else {
                    left_rotate(n.left);
                    right_rotate(n);
                }
                return 0;
            }
        }
    }

    public Node insertToAVL(Node node, int data) {
        // code here
       // if(node == null)return new Node(data)
        avl(node, data);
        return node;
    }
}
