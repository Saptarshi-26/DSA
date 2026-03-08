package Tree;
import java.util.*;
public class PathSum {
   static boolean sum(Node n , int sum , int target){
        sum+=n.data;
        if(n.left==null&&n.right==null){
            if(sum==target)return true;
            else return false;
        }
        boolean t= false;
        if(n.left!=null){
            t=sum(n.left,sum,target);
        }
        if(t)return t;
        if(n.right!=null){
            t=sum(n.right,sum,target);
        }
        return t;
    }
   static boolean hasPathSum(Node root, int target) {
        // Your code here
       boolean t=sum(root,0,target);
       System.out.println(t);
       return t;
    }
}
