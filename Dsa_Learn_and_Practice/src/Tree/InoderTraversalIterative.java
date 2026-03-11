package Tree;
import java.util.*;
public class InoderTraversalIterative {
    ArrayList<Integer> inOrder(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        if(root==null)return ans ;
        st.push(root);
        while(!st.isEmpty()){
            Node n=null;
            if(st.peek().left!=null){
                n=st.peek().left;
                st.peek().left=null;
                st.push(n);
            }
            else if(st.peek().right!=null){
                n=st.pop();
                ans.add(n.data);
                st.push(n.right);
            }
            else {
                ans.add(st.pop().data);
            }
        }
        for(int x:ans ) System.out.print(x+" ");
       return ans ;
    }
}
