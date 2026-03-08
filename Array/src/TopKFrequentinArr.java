import java.util.*;
public class TopKFrequentinArr {
    public static ArrayList<Integer> topKFrequent(int[] arr, int k) {
        // Your code here
        HashMap<Integer,Integer> h = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int x:arr){
            if(!h.containsKey(x))h.put(x,1);
            else h.put(x,h.get(x)+1);
        }
        TreeMap<Integer,TreeSet<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        for(int x:arr){
            if(!h.containsKey(x))continue;
            if(!map.containsKey(h.get(x))){
                TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
                set.add(x);
                map.put(h.get(x),set);
            }
            else {
                map.get(h.get(x)).add(x);

            }
            h.remove(x);
        }
        for (Map.Entry<Integer, TreeSet<Integer>> entry : map.entrySet()) {
            TreeSet<Integer> set = entry.getValue();
            for (int value : set) {
                ans.add(value);
                k--;
                if(k==0)break;
            }
            if(k==0)break;
        }
        return ans ;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println("Enter the top k number");
        int k=sc.nextInt();
        System.out.println(topKFrequent(arr,k));
    }
}
