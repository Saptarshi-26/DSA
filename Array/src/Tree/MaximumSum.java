package Tree;
import java.util.*;
public class MaximumSum {
   static  int[] sum(Node n) {
       if(n.left == null && n.right == null) return new int[] {n.data, n.data};

       int[] a = new int[2];
       int[] arr = new int[2];

       if(n.left != null) a = sum(n.left);
       if(n.right != null) arr = sum(n.right);

       int[] max = new int[2];
       max[0] = Math.max(n.left != null ? a[0] : arr[0], n.right != null ? arr[0] : a[0]);

       if(n.left != null && n.right != null) {
           int temp = a[0] + arr[0] + n.data;
           max[1] = Math.max(arr[1], a[1]);
           max[1] = Math.max(temp, max[1]);
       } else {
           if(n.left == null) max[1] = arr[1];
           else max[1] = a[1];
       }

       if(n.data < 0) {
           max[1] = Math.max(max[1], max[0] > 0 ? max[0] : max[1]);
           max[1] = Math.max(max[1], n.data);
           max[0] = max[0] < 0 ? 0 : (max[0] + n.data);
       } else {
           if(max[0] < 0) max[0] = 0;
           max[0] += n.data;
       }

       return max;
   }

    static  int findMaxSum(Node n ){
        // your code goes here
        int ans []= sum(n);
        if(ans[0]==0)return ans[1];
        return Math.max(ans[0],ans[1]);
    }

}
