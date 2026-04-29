package linkedlsit;
import java.util.*;
public class Node {
    int data;
    Node next;
    Node prev;
    Node random;
    Node(){

    }
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
