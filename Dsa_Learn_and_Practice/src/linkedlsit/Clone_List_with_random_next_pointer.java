package linkedlsit;

import java.util.HashMap;

public class Clone_List_with_random_next_pointer {
    Node clone_list(Node n, HashMap<Node, Node> map) {
        if (n == null) return null;
        Node new_Node = new Node(n.data);
        map.put(n, new_Node);
        new_Node.next = clone_list(n.next, map);
        if (n.random != null) {
            new_Node.random = map.get(n.random);
        }
        return new_Node;

    }

    public Node cloneLinkedList(Node head) {
        // code here
        return clone_list(head, new HashMap<>());
    }
}
