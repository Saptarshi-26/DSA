package Tree;
import java.util.*; // gfg
public class FullBInaryTree {
    boolean isFullTree(Node n)
    {
        //add code here.
        if(!(n.left!=null&&n.right!=null)){
            return n.left == null && n.right == null;
        }
        return isFullTree(n.left)&&isFullTree(n.right);
    }
}
