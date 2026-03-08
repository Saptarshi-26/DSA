package Tree;
import java.util.*;
import java.util.stream.Collectors;

public class PathFromRootwithSpecificSum {
    public static ArrayList<ArrayList<Integer>> sum(Node n , int sum ,int s){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(n==null)return ans;
        if(s+n.data==sum){
            ans.add(new ArrayList<>(List.of(n.data)));
        }
        ArrayList<ArrayList<Integer>> temp= new ArrayList<>(sum(n.left,sum,s+n.data));
        temp.addAll(sum(n.right,sum,s+n.data));
        if(!temp.isEmpty()){
            ans.addAll(temp.stream().peek(x -> x.addFirst(n.data)).toList());

        }
        return ans;

    }
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum)
    {
        // code here
        return new ArrayList<>(sum(root,sum,0));
    }
}
