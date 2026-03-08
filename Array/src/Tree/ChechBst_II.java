package Tree;

import java.util.*;

public class ChechBst_II {
    static boolean isBst(Node n , ArrayList<Integer> a){
        if(n.left==null&&n.right==null){
            a.add(n.data);
            return true;
        }
        int tem=0;
        if(n.left!=null){
            if(!isBst(n.left,a)||a.get(a.size()-1)>=n.data)return false;
            tem=a.get(0);
        }
        a.clear();
        int temp=0;
        if(n.right!=null){
            if(!isBst(n.right,a)||a.get(0)<=n.data)return false;
            temp=a.get(a.size()-1);
        }
        a.clear();
        if(n.left!=null)a.add(Math.min(n.data,tem));
        if(n.right!=null)a.add((Math.max(n.data,temp)));
        return true;
        }
    static boolean isBST(Node root) {
        // code here.
        return isBst( root , new ArrayList<>());
    }
}
