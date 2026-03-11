package linkedlsit;

public class PalindromicLinkedList {

        // Function to check whether the list is palindrome.
        static Node palin(Node n ,Node nn){
            if(n.next==null){
                if(n.data!=nn.data)return null;
                return nn;
            }
            Node t=palin(n.next,nn);
            if(t==null)return null;
            if(t.next.data!=n.data)return null;
            return t.next;
        }
        static boolean isPalindrome(Node n) {
            // Your code here
            if(palin(n,n)==null)return false;
            return true;
        }
    }

