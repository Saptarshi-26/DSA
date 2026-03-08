package Tree;
import java.util.*;
public class BottomViewBinaryTree {
    static void btmview(ArrayList<ArrayList<Node>> arr, HashMap<Integer,Node > h ,int[] minmax){
         ArrayList<ArrayList<Node>> a = new ArrayList<>();
         for(ArrayList<Node> x: arr) {
             if (x.get(1).left != null) {

                 ArrayList<Node> temp = new ArrayList<>();

                 int val = x.get(0).data - 1;

                 temp.add(new Node(val));

                 temp.add(x.get(1).left);

                 a.add(temp);

                 h.put(val, x.get(1).left);

                 if (val < minmax[0]) minmax[0] = val;

             }
             if (x.get(1).right != null) {

                 ArrayList<Node> temp = new ArrayList<>();

                 int val = x.get(0).data + 1;

                 temp.add(new Node(val));

                 temp.add(x.get(1).right);

                 a.add(temp);

                 h.put(val, x.get(1).right);

                 if (val > minmax[1]) minmax[1] = val;

             }
         }
             if(a.size()>0){
                 btmview(a,h,minmax);
             }

    }
    public static ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Node> temp = new ArrayList<>();
        temp.add(new Node(0));
        temp.add(root);
        ArrayList<ArrayList<Node>> arr = new ArrayList<>();
        arr.add(temp);
        HashMap<Integer,Node> h = new HashMap<>();
        h.put(0,root);
        int[] minmax={0,0};
        btmview(arr,h,minmax);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=minmax[0];i<=minmax[1];i++){
            ans.add(h.get(i).data);
        }
        System.out.println(ans);
        return ans ;
    }
}
