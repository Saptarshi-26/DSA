package Tree;

import java.util.HashMap;
import java.util.Map;

public class Maximum_Width_of_Binary_Tree {
    public int width(HashMap<Integer, Node> map) {
        HashMap<Integer, Node> newMap = new HashMap<>();
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (Integer key : map.keySet()) {
            if (map.get(key).left != null) {
                newMap.put((key * 2) + 1, map.get(key).left);
                start = Math.min(start, (key * 2) + 1);
                end = Math.max(end, (key * 2) + 1);
            }
            if (map.get(key).right != null) {
                newMap.put((key * 2) + 2, map.get(key).right);
                start = Math.min(start, (key * 2) + 2);
                end = Math.max(end, (key * 2) + 2);
            }
        }

        return newMap.isEmpty()?0:Math.max((end+1)-start,width(newMap));

    }

    public int widthOfBinaryTree(Node root) {
        return width(new HashMap<>(Map.of(0, root)));
    }
}
