package Tree;
import java.util.*;
public class RightViewBinaryTree {
    int r(Node n , ArrayList<Integer>arr, int max,int c){
        if(c>max)arr.add(n.data);
        if(n.left==null&&n.right==null){
            if(c>max)max=c;
            return max;
        }
        if(n.right!=null){
            int t=r(n.right,arr,max,c+1);
            if(t>max)max=t;
        }
        if(n.left!=null){
            int t=r(n.left,arr,max,c+1);
            if(t>max)max=t;
        }
        return max;
    }
    ArrayList<Integer> rightView(Node root) {
        // add code here.
        ArrayList<Integer> arr = new ArrayList<>();
        r(root,arr,0,1);
        return arr;
    }
}
