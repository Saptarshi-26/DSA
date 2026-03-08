package Tree;
import java.util.*;
public class Symetri_Tree {
    static boolean ismirror(ArrayList<Node> arr,ArrayList<String > s){
        ArrayList<Node > a = new ArrayList<>();
        for (Node node : arr) {
            if (node.left != null) {
                s.add(Integer.toString(node.left.data));
                a.add(node.left);
            } else s.add("NUll");
            if (node.right != null) {
                s.add(Integer.toString(node.right.data));
                a.add(node.right);
            } else s.add("NUll");
        }
        if(a.isEmpty())return true;
        int i=0; int j=s.size()-1;
        while(i<=j){
            if(!(s.get(i).equals(s.get(j))))return false;
            i++;j--;
        }
       return ismirror(a,new ArrayList<>());

    }
    public static boolean isSymmetric(Node root) {
        // your code here;
        ArrayList<Node> arr = new ArrayList<>();
        arr.add(root);
       boolean t = ismirror(arr, new ArrayList<>());
        System.out.println(t);
        return t;
    }
}
