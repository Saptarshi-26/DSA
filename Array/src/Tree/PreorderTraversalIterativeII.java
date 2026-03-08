package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversalIterativeII {
    public void modify(Stack<Node> s,Stack<Node>st,ArrayList<Integer> ans){
        if(s.size()>0&&s.peek().right!=null){
            Node n= s.pop().right;
            st.push(n);
            ans.add(n.data);
            if(n.right!=null&&n.left!=null)s.push(n);

        }
    }
    ArrayList<Integer> preOrder(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null)return ans;
        Stack<Node> st = new Stack<>();
        Stack<Node> s = new Stack<>();
        st.push(root);
        ans.add(root.data);
        if(root.right!=null&&root.left!=null)s.push(root);
        while(!s.isEmpty() ||(st.peek().left!=null||st.peek().right!=null)){
            Node n=null;
            if(st.peek().left!=null)n=st.peek().left;
            else if(st.peek().right!=null)n=st.peek().right;
            else modify(s,st,ans);
            if(n!=null){
                st.push(n);
                ans.add(n.data);
                if(n.right!=null&&n.left!=null)s.push(n);
            }

        }
//        while(st.size()>0){
//            ans.add(0,st.pop().data);
//        }
        for(int x:ans ) System.out.print(x+" ");
        return ans ;
    }
}
