package Tree;

public class InserBst {
    void inser(Node n ,int  k){
        if(n.data==k)return ;
        if(n.data>k){
            if(n.left==null){
                Node kk= new Node(k);
                n.left=kk;
                return ;
            }
            else inser(n.left,k);
        }

        if(n.data<k){
            if(n.right==null){
                Node kk= new Node(k);
                n.right=kk;
                return ;
            }
            else inser(n.right,k);
        }

    }
    Node insert(Node root, int Key) {
        // your code here
        inser(root,Key);
        return  root;
    }
}
