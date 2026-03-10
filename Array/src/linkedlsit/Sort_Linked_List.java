package linkedlsit;

public class Sort_Linked_List {
    public void sort(Node n, int length, Node max) {
        if (n.data > max.data) max = n;
        if (length == 0) {
            int temp = n.data;
            n.data = max.data;
            max.data = temp;
        } else {
            sort(n.next, length - 1, max);
        }

    }

    public Node sortList(Node n) {
        int count = 0;
        Node temp = n;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }

        for (int i = 0, length = count; i < length; i++, count--)
            sort(n, count, n);
        return n;
    }
}
