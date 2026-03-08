package linkedlsit;
import java.util.*;
public class Intersections_in_Y_shaped_list {
   static Node find( Node a , Node b , int c ){
        if(a==null&&b==null)return null;
        if(c<=0){
            if(a.equals(b))return a;
            return find(a.next,b.next,c-1);
        }
        return find(a.next,b,c-1);
    }
    static Node intersectPoint(Node h1, Node h2) {
        // code here
        int c=0;int c1=0;
        Node a = h1;
        Node b = h2;
        while(a!=null||b!=null){
            if(a!=null){
                c++;a=a.next;
            }
            if(b!=null){
                c1++;
                b=b.next;
            }
        }
        a=h1;
        b=h2;
        if(c>c1)return find(a,b,c-c1);
        return find(b,a,c1-c);

    }
}
