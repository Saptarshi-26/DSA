package Tree;
import java.util.*;

public class PreorderTraversalIterative {
    public static void main(String[] args) {

    }
    ArrayList<Integer> preOrder(Node root)
    {
        // Code
        ArrayList<Node> a = new ArrayList<>();
        ArrayList<Node> n = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        n.add(root);
        int i=0;
        boolean t= true;
        while(t){
            t=false;
            a.addAll(n);
            n= new ArrayList<>();
            for(;i<a.size();i++){
                if(a.get(i)==null){
                    n.add(null);n.add(null);
                    continue;
                }
                if(a.get(i).left!=null){
                    t=true;n.add(a.get(i).left);
                }else n.add(null);
                if(a.get(i).right!=null){
                    t=true;
                    n.add(a.get(i).right);
                }
                else n.add(null);
            }

        }
        i--;
        int c =2;
   while(i>=0){
       int j=n.size()-c;
       while(j>=0){
           n.add(j,a.get(i));
           j-=c;
           i--;
       }
       c++;
       c*=2;
   }
//        for(i=0;i<n.size();i++){
//            if(n.get(i)==null) System.out.print("null ");
//            else System.out.print(n.get(i).data+" ");
//        }
       for(i=0;i<n.size();i++)if(n.get(i)!=null)ans.add(n.get(i).data);
      // for(int x:ans) System.out.print(x+" ");

  return ans ;
    }
}
