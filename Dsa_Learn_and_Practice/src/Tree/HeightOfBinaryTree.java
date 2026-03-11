package Tree;
import java.util.*;
public class HeightOfBinaryTree {
    int height(Node n) {
        // code here
        if(n==null)return 0;
        if(n.left==null&&n.right==null)return 1 ;
        return ((int)Math.max(n.left!=null?height(n.left):0,n.right!=null?height(n.right):0))+1;
    }
}
