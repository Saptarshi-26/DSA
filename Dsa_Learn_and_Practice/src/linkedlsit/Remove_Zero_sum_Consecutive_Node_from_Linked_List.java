package linkedlsit;

import java.util.HashMap;

public class Remove_Zero_sum_Consecutive_Node_from_Linked_List {
    Node remove_zero_sum(Node n, HashMap<Integer, Integer> map, int sum) {
        if (n == null) {
            return null;
        }
        sum += n.data;
        map.put(sum, map.containsKey(sum) ? map.get(sum) + 1 : 1);
        if (sum == 0 || map.get(sum) > 1) {
            return n;
        }

        Node temp = remove_zero_sum(n.next, map, sum);
        while (temp != null) {
            if (map.get(sum) > 1) {
                map.put(sum, 1);
                n.next = temp.next;
                temp = remove_zero_sum(n.next, map, sum);
                continue;
            }
            map.remove(sum);
            return temp;

        }
        return temp;

    }

    public Node removeZeroSumSublists(Node head) {
        Node ans = head;
        HashMap<Integer, Integer> map = new HashMap<>();
        Node temp = remove_zero_sum(ans, map, 0);
        while (temp != null) {
            ans = temp.next;
            temp = remove_zero_sum(ans, map, 0);
        }
        return ans;

    }
}
