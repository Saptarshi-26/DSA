package Tree;
import java.util.*;
public class VerticalTraversalBinaryTree {

    static int[] v(HashMap<Integer,TreeMap<Integer,ArrayList<Integer>>> h ,
                   int[] minmax,Node n,int i , int level){
        if (n == null) return minmax;

        minmax = v(h, minmax, n.left, i + 1, level + 1);
        minmax = v(h, minmax, n.right, i - 1, level + 1);

        minmax[0] = Math.max(i, minmax[0]);
        minmax[1] = Math.min(i, minmax[1]);

        if (!h.containsKey(i)) {
            TreeMap<Integer, ArrayList<Integer>> tree = new TreeMap<>();
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(n.data);
            tree.put(level, arr);
            h.put(i, tree);
        }
        else if (!h.get(i).containsKey(level)) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(n.data);
            h.get(i).put(level, arr);
        }
        else
        h.get(i).get(level).add(n.data);

        return minmax;
    }
    static ArrayList<ArrayList<Integer>> verticalOrder(Node root)
    {
        // add your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int arr[] = new int[2];
        arr[0]=-1;
        arr[1]=Integer.MAX_VALUE;
        HashMap<Integer,TreeMap<Integer,ArrayList<Integer>>> h = new HashMap<>();
        arr = v(h,arr,root,0,0);
        for(int i=arr[0];i>=arr[1];i--){
            TreeMap<Integer,ArrayList<Integer>> tree = h.get(i);
            ArrayList<Integer> temp = new ArrayList<>();
            for (Map.Entry<Integer, ArrayList<Integer>> entry : tree.entrySet()) {
                Integer key = entry.getKey();          // Access the key
                ArrayList<Integer> values = entry.getValue(); // Access the associated ArrayList
                if(values.size()>1)Collections.sort(values);
                temp.addAll(values);
                // You can process the key and values as needed here (no printing required)
            }
            ans.add(temp);
        }
        System.out.println(ans);
    return ans;
    }
}
