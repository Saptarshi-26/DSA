import linkedlsit.Input;

import java.util.*;

public class Longest_Increasing_Subsequence {

    public static ArrayList<Integer> lis(int[] arr, int i, HashMap<Integer, HashSet<ArrayList<Integer>>> h, ArrayList<Integer> a) {

        if (h.containsKey(i)) {
            if (h.get(i).contains(a)) return new ArrayList<>();
            else h.get(i).add(new ArrayList<>(a));
        } else h.put(i, new HashSet<>(Set.of(new ArrayList<>(a))));

        if (i == arr.length) return a;
        ArrayList<Integer> a2;
        ArrayList<Integer> a1 = new ArrayList<>(lis(arr, i + 1, h, new ArrayList<>(a)));
        //System.out.println(a1);
        if (!a.isEmpty() && arr[i] > a.getLast()) {

            ArrayList<Integer> temp = new ArrayList<>(a);
            temp.add(arr[i]);
            a2 = new ArrayList<>(lis(arr, i + 1, h, temp));
            // System.out.println(a2);
        } else {
            a2 = lis(arr, i + 1, h, new ArrayList<>(List.of(arr[i])));
        }
        System.out.println(a1);
        System.out.println(a2);
        return a1.size() >= a2.size() ? a1 : a2;

    }

    public static ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        return lis(arr, 0, new HashMap<>(), new ArrayList<>());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ënter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
        System.out.println(getLIS(arr));
    }
}
