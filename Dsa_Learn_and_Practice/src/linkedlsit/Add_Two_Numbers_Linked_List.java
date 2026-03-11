package linkedlsit;

public class Add_Two_Numbers_Linked_List {
    public Node[] add(Node a, Node b, int c) {
        if (a.next == null && b.next == null) {
            return new Node[]{new Node((a.data + b.data) % 10), new Node((a.data + b.data) > 9 ? 1 : 0)};
        }
        Node[] arr;
        if (c == 0) {
            arr = add(a.next, b.next, c);
        } else arr = add(a.next, b, c - 1);

        int val = a.data + ((c == 0) ? b.data : 0) + arr[1].data;

        Node[] ans = {new Node(0), new Node(0)};

        ans[0].data = val % 10;
        ans[1].data = val > 9 ? 1 : 0;

        ans[0].next = arr[0];

        return ans;

    }

    Node reverse(Node n) {
        if (n.next == null) return n;
        Node ans = reverse(n.next);
        n.next.next = n;
        n.next = null;
        return ans;
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int c1 = 0;
        int c2 = 0;
        Node a = l1;
        Node b = l2;
        while (a != null || b != null) {
            c1 = a != null ? c1 + 1 : c1;
            c2 = b != null ? c2 + 1 : c2;
            a = a != null && a.next != null ? a.next : null;
            b = b != null && b.next != null ? b.next : null;
        }
        int c = Math.abs(c1 - c2);

        Node ans = new Node();
        Node[] n = new Node[2];
        if (c1 > c2) n = add(l1, l2, c);
        else n = add(l2, l1, c);
        if (n[1].data > 0) {
            ans.data = 1;
            ans.next = n[0];
        } else ans = n[0];
        return reverse(ans);


    }


}
