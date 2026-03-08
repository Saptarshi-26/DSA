import java.util.*;
public class MajorityElement {
    public static List<Integer> findMajority(int[] arr) {
        // Your code goes here.
        List<Integer> ans= new ArrayList<>();
        TreeMap<Integer,Integer> h = new TreeMap<>();
        for(int i=0;i<arr.length;i++)
        {
            if(!h.containsKey(arr[i]))h.put(arr[i],1);
            else h.put(arr[i],h.get(arr[i])+1);

        }
        for (Map.Entry<Integer, Integer> x : h.entrySet()) {
            if(x.getValue()>(arr.length/3))ans.add(x.getKey());
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println(findMajority(arr));
    }
}
