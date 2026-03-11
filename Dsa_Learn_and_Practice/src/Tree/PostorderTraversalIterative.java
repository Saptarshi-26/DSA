package Tree;

import java.util.*;

public class PostorderTraversalIterative {
    ArrayList<Integer> postOrder(Node node) {
        // code here
        Stack<Node>  st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(node==null)return ans ;
        st.push(node);
        while(!st.isEmpty()){
            Node n = null;
            if(st.peek().left!=null){
                n=st.peek().left;
                st.peek().left=null;
                st.push(n);
            }
            else if(st.peek().right!=null){
                n=st.peek().right;
                st.peek().right=null;
                st.push(n);
            }
            else{
                ans.add(st.pop().data);
            }


        }
        for(int x:ans) System.out.print(x+" ");
        return ans;
    }
}
