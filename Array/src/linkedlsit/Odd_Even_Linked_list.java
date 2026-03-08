package linkedlsit;

public class Odd_Even_Linked_list {
    public Node[] odd_eve(Node n, int c) {
        if (n.next == null) {
            if (c % 2 == 0) return new Node[]{n, null};
            return new Node[]{null, n};
        }
        Node[] node = odd_eve(n.next, c + 1);

        if (c % 2 == 0) {
            n.next = node[0];
            node[0] = n;
        } else {
            n.next = node[1];
            node[1] = n;
        }
        return node;
    }

    public Node oddEvenList(Node head) {
        if (head == null) return head;
        Node[] node = odd_eve(head, 1);
        Node temp = node[1];
        while (temp.next != null) temp = temp.next;
        temp.next = node[0];
        return node[1];
    }
}
