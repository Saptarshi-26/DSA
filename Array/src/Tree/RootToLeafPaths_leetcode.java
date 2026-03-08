package Tree;
import java.util.*;
public class RootToLeafPaths_leetcode {
    public static List<String> binaryTreePaths(Node n) {
        List<String> s = new ArrayList<>();
        if(n.left==null&&n.right==null){
            s.add(Integer.toString(n.data));
            return s;
        }
        if(n.left!=null){
            s.addAll(binaryTreePaths(n.left));
        }
        if(n.right!=null){
            s.addAll(binaryTreePaths(n.right));
        }
        s.replaceAll(string -> Integer.toString(n.data) + "->" + string);
        return s;
    }
}
