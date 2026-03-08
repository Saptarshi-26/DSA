package Tree;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class CheckForBst {
   static ArrayList<Integer> isBst(Node n , AtomicBoolean t){
       if(n.left==null&&n.right==null)return new ArrayList<>(List.of(n.data));
       ArrayList<Integer> a = new ArrayList<>();
       if(!t.get())return a;
       if(n.left!=null) {
           a = isBst(n.left, t);
           if (!a.isEmpty() &&a.getLast() >= n.data) {
               t.set(false);
               return a;
           }
       }
           ArrayList<Integer> a1 = new ArrayList<>();
           if(n.right!=null){
               a1=isBst(n.right,t);
               if(!a1.isEmpty() &&a1.getFirst()<=n.data){
                   t.set(false);
                   return a1;
               }
           }
           a.add(n.data);
           a.addAll(a1);
           return new ArrayList<>(List.of(a.getFirst(),a.getLast()));
       }

   static boolean isBST(Node root) {
        // code here
       AtomicBoolean t = new AtomicBoolean(true);
       isBst(root,t);
       return t.get();

    }
}
