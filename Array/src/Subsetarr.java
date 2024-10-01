
import java.util.*;
public class Subsetarr {
    public static void sortLexicographically(ArrayList<ArrayList<Integer>> listOfLists) {
        Collections.sort(listOfLists, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
                int minSize = Math.min(list1.size(), list2.size());

                // Compare each element in both lists
                for (int i = 0; i < minSize; i++) {
                    int cmp = list1.get(i).compareTo(list2.get(i));
                    if (cmp != 0) {
                        return cmp; // If elements are not equal, return comparison result
                    }
                }
                // If lists are identical up to the length of the shorter one, compare by size
                return Integer.compare(list1.size(), list2.size());
            }
        });
    }
    public static ArrayList<ArrayList<Integer>> subs(ArrayList<Integer>arr , ArrayList<Integer>a){
        if(a.size()==0){
            ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
            ar.add(new ArrayList<>(arr));
            return ar;
        }
        ArrayList<ArrayList<Integer>>ar= new ArrayList<>();
        int temp=a.get(0);
        a.remove(0);
        arr.add(temp);
        ar.addAll(subs(arr, a));
        arr.remove(arr.size()-1);
        ar.addAll(subs(arr, a));
        a.add(0, temp);
        return ar;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take the input for the number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Create an ArrayList to store the numbers
        ArrayList<Integer> arr = new ArrayList<>();

        // Input n numbers from the user
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        // Call the subs method to generate subsets
        ArrayList<ArrayList<Integer>> ar = subs(new ArrayList<>(), arr);  // Fix: Pass new empty list as first arg

        // Print the subsets
        sortLexicographically(ar);
        for (ArrayList<Integer> innerList : ar) {
            for (Integer num : innerList) {
                System.out.print(num + " ");
            }
            System.out.println(); // Move to the next line after printing each inner list
        }
    }
}
