package linkedlsit;

import java.util.Stack;

public class Reorder_List {
    public void reorderList(Node head) {
        // code here
        Stack<Node> st = new Stack<>();
        Node current = head;
        while(current!=null){
            st.push(current);
            current=current.next;
        }
        int size = st.size();
        current = head;
        while(size>1){
            size-=2;
            Node next = current.next;
            current.next=st.pop();
            current.next.next=next;

            if(size<=1){
                next.next=null;
            }
            else{
            current=next;
            }

        }
    }

}
