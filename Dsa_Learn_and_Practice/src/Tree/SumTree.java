package Tree;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SumTree {
   static int sum(Node n , Boolean t[]){
        if(n.left==null&&n.right==null)return n.data;
        int sum=0;
        if(n.left!=null){
            sum=sum(n.left,t);
        }
        if(n.right!=null){
            sum+=sum(n.right,t);
        }
        if(!t[0]||n.data!=sum){
            t[0]=false;
            return 0;
        }
        return n.data+sum;

    }
  static   boolean isSumTree(Node root) {
        // Your code here
      Boolean t[] = {true};
      sum(root,t);
      return t[0];
    }
}
