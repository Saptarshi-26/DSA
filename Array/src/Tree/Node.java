package Tree;
public class Node {

    int data;
    Node right;
    Node left;
    Node prev;
    Node next;
    Node nextRight;
     Node(){}
   public  Node(int data) {
       this.data = data;
       this.left = null;
       this.right = null;
       this.prev = null;
       this.nextRight=null;
    }
}





