package linkedlsit;

import java.util.HashMap;

public class Remove_Zero_sum_Consecutive_Node_from_Linked_List {
    Node[] remove_zero_sum(Node n, HashMap<Integer, Node> map, int sum) {
        if (n == null) {
            return new Node[2];
        }
        sum += n.data;
        if (map.containsKey(sum)) {
            return new Node[]{new Node(sum), n.next};
        }

        map.put(sum, n);
        Node[] temp = remove_zero_sum(n.next, map, sum);
        while (temp[0] != null) {
            map.remove(sum);
            if (temp[0].data == sum) {
                n.next = temp[1].next;
                temp = remove_zero_sum(n.next, map, sum);
            } else return temp;
        }
        return temp;

    }

    public Node removeZeroSumSublists(Node head) {
        Node ans = head;
        HashMap<Integer, Node> map = new HashMap<>();
        Node[] temp = remove_zero_sum(ans, map, 0);
        while (temp[0] != null) {
            ans = temp[1].next;
            temp = remove_zero_sum(ans, map, 0);
        }
        return ans;

    }
}
