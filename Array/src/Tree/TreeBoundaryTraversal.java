package Tree;
import java.util.*;
public class TreeBoundaryTraversal {
   static ArrayList<Integer> left(Node n ){
        if(n.left==null&&n.right==null)return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(n.left!=null){
            ans.addAll(left(n.left));
        }else ans.addAll(left(n.right));
        ans.add(0,n.data);
        return ans;
    }
  static ArrayList<Integer> right(Node n ){
        if(n.left==null&&n.right==null)return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(n.right!=null){
            ans.addAll(right(n.right));
        }else  ans.addAll(right(n.left));
        ans.add(n.data);
        return ans;
    }
  static ArrayList<Integer> leaf(Node n ){
        if(n.left==null&&n.right==null)
            return new ArrayList<>(List.of(n.data));
        ArrayList<Integer> ans = new ArrayList<>();
        if(n.left!=null) ans.addAll(leaf(n.left));
        if(n.right!=null)ans.addAll(leaf(n.right));
        return ans;
    }

  static ArrayList<Integer> boundaryTraversal(Node n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(n.data);
        if(n.left!=null) ans.addAll(left(n.left));
        if(n.left!=null||n.right!=null) ans.addAll(leaf(n));
        if(n.right!=null)ans.addAll(right(n.right));
        return ans;

    }
}
