package Tree;

import java.util.*;

public class Fixing_Two_Nodes_of_Bst {
    void swap(Node a, Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;

    }

    ArrayList<Node> inorder(Node n) {
        ArrayList<Node> inorder_List = new ArrayList<>();
        if (n == null) return inorder_List;
        inorder_List.addAll(inorder(n.left));
        inorder_List.add(n);
        inorder_List.addAll(inorder(n.right));
        return inorder_List;
    }

    void correctBST(Node n) {
        // code here.
        ArrayList<Node> arr = new ArrayList<>(inorder(n));
        int[] index_arr = {-1, -1};
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i).data > arr.get(i + 1).data) {
                if (index_arr[0] == -1) {
                    index_arr[0] = i;
                } else {
                    index_arr[1] = i + 1;
                    break;
                }
            }
        }
        if (index_arr[1] == -1) {
            swap(arr.get(index_arr[0]), arr.get(index_arr[0] + 1));
            return;
        }
        swap(arr.get(index_arr[0]), arr.get(index_arr[1]));

    }
}
