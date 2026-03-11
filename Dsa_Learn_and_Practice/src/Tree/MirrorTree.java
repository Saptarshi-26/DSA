package Tree;
import java.util.*;
public class MirrorTree {
   static void mirror(Node node) {
        // Your code here
          if(node==null)return;
          mirror(node.left);
          mirror(node.right);
          Node t = node.right;
          node.right=node.left;
          node.left=t;

    }
}

