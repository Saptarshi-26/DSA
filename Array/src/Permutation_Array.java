import java.util.*;

public class Permutation_Array {
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr, int i) {
        // code here
        if (i == arr.length - 1) return new ArrayList<>(List.of(new ArrayList<>(List.of(arr[i]))));
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> temp = uniquePerms(arr, i + 1);
        for (ArrayList<Integer> x : temp) {
            for (int j = 0; j < x.size(); j++) {
                ArrayList<Integer> a = new ArrayList<>(x);
                a.add(j, arr[i]);
                ans.add(a);
            }
            ArrayList<Integer> a = new ArrayList<>(x);
            a.add(arr[i]);
            ans.add(a);
        }
        return ans;

    }

    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        // code here
        return new ArrayList<>(uniquePerms(arr, 0));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(uniquePerms(arr));

    }
}
