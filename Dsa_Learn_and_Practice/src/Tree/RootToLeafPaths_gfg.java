package Tree;
import java.util.*;
public class RootToLeafPaths_gfg {
    public static ArrayList<ArrayList<Integer>> Paths(Node n) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (n.left == null && n.right == null) {
            ans.add(new ArrayList<>(List.of(n.data)));
            return ans;
        }
        if (n.left != null) {
            ans.addAll(Paths(n.left));
        }
        if (n.right != null) {
            ans.addAll(Paths(n.right));
        }
        for (ArrayList<Integer> x : ans) {
            x.addFirst(n.data);
        }
        return ans;
    }

}

