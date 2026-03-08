package linkedlsit;
import java.util.*;
public class RotateaLinkedList {
    public Node rotate(Node n, int k) {
        // add code here
         List<Node> arr = new ArrayList<>();
         while(n!=null){
             arr.add(n);
             n=n.next;
         }
         while(k>arr.size())k=k%arr.size();
         if(k==arr.size())return arr.getFirst() ;
         Node ans=arr.get(k);
         arr.get(k-1).next=null;
         arr.getLast().next=arr.getFirst();
         return ans;

    }
}
