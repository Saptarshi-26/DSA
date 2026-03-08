package Tree;
import java.util.*;
public class BstToGreaterTree_leetocde {
    public static int greater(Node n , int a){
        if(n.left==null&&n.right==null){
            return n.data=n.data+a;
        }
        int temp=n.data;
        if(n.right!=null){
            temp=n.data=n.data+greater(n.right,a);
        }
        if(n.left!=null){
            if(n.right==null){
              temp=n.data=n.data+a;
            }
            return greater(n.left,temp);
        }
        return temp;
    }
    static Node convertBST(Node root) {
        greater(root,0);
        return root;
    }

}
