package linkedlsit;
import javax.sound.midi.SysexMessage;
import java.util.*;
public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes ");
        int n=sc.nextInt();
        Node head=new Node(0);
        Node Node = head;
        for(int i=0;i<n;i++){
            head.data=sc.nextInt();
           //f(Node==null)Node =head;
            if(i==n-1)head.next=null;
          else  head.next=new Node(0);
          head=head.next;
        }

//        while(Node.next!=null){
//            System.out.println(Node.data);
//            Node=Node.next;
//        }
//        System.out.println(Node.data);
        //System.out.println(PalindromicLinkedList.isPalindrome(Node));
    }

}
