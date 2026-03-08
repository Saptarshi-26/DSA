package linkedlsit;
import java.util.*;
public class Merge_K_sorted_linkedList {
    Node merge(Node a , Node b){
        if(a==null&&b==null)return null;
        if(a==null&&b!=null)return b;
        if(b==null&&a!=null)return a ;
        Node n = new Node (Math.min(a.data,b.data));
        n.next = (a.data<b.data)?merge(a.next,b):merge(b.next,a);
        return n;
    }
    Node m(List<Node> arr , int i , int j){
        if(i==j)return arr.get(i);
        if(i==j-1)return merge(arr.get(i),arr.get(j));
        return merge(m(arr,i,(i+j)/2),m(arr,((i+j)/2)+1,j));
    }
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        return m(arr, 0 , arr.size()-1);

    }
}
