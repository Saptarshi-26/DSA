import java.util.*;

public class Find_K_Closest_Elements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int a : arr) {
            int key = Math.abs(x - a);
            if (map.containsKey(key)) {
                map.get(key).add(a);
            } else {
                map.put(key, new ArrayList<>(List.of(a)));
            }
        }
        List<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            //entry.getValue().sort((a,b)->b-a);
            for (Integer a : entry.getValue()) {
                if (k == 0) break;
                ans.add(a);
                k--;
            }
            if (k == 0) break;
        }
        ans.sort(Comparator.naturalOrder());
//        ans.sort(Comparator.naturalOrder());
//        int[] ans_arr = new int[ans.size()];
//        Stream.iterate(0,a->a+1).
//                limit(ans.size()).forEach(i->ans_arr[i]=ans.get(i));
        return ans;

    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the k for closest elements ");
        int k = sc.nextInt();
        System.out.println("enter the the element for which the closest  elements to be found ");
        int x = sc.nextInt();
        new Find_K_Closest_Elements().findClosestElements(arr, k, x).forEach(ans -> System.out.print(ans + " "));

    }
}
