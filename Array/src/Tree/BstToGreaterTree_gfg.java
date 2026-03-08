package Tree;
import java.util.*;
public class BstToGreaterTree_gfg {

    public static int greater(Node n , int a , char ch ){
    if(n.left==null&&n.right==null){
        int t = n.data;
        n.data=a;
        
       return t+a ;
    }
    int temp=n.data;
    if(n.right!=null){
        n.data=greater(n.right,a,'r');
        temp+=n.data;
    }
    if(n.left!=null){
        if(n.right==null) {
            n.data = a;

            temp = greater(n.left, temp+a, 'l');
        }
        else{
            temp = greater(n.left, temp, 'l');
        }
    }
    return temp;
}

    public static void transformTree (Node root)
    {
        greater(root,0,'r');
    }
}
