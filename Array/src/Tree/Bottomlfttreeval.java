package Tree;
import java.util.*;
public class Bottomlfttreeval {
    static int[] lftmst(int[] arr, Node n){
       if(n.left==null&&n.right==null)return arr;
      int ans1[] = new int[2];
      int ans2[] = new int[2];
      if(n.left!=null){
          int temp [] = new int[2];
          temp[0]=n.left.data;
          temp[1]=arr[1]+1;
          ans1=lftmst(temp,n.left);
      }
      if(n.right!=null){
          int temp [] = new int[2];
          temp[0]=n.right.data;
          temp[1]=arr[1]+1;
          ans2=lftmst(temp,n.right);
      }
      if((ans1[1]==ans2[1])&&ans1[1]!=0){
          arr=ans1;
      }
      else {
          arr = (ans1[1] > 0 || ans2[1] > 0) ? (ans1[1] > ans2[1]) ? ans1 : ans2 : arr;
      }
        return arr;
    }
    public static int findBottomLeftValue(Node root) {
        int ans[] = new int[2];
        ans = lftmst(ans, root);
        if(ans[1]==0)ans[0]=root.data;
        return ans[0];
    }
}
