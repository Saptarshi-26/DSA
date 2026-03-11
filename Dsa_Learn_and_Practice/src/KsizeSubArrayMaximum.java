import java.util.*;
public class KsizeSubArrayMaximum {
    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        TreeMap<Integer,Integer> h = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int j=0;
        for(int i=0;i<arr.length;i++){
            h.put(arr[i],h.containsKey(arr[i])?h.get(arr[i])+1:1);
            if(i>=k-1){
                if(i>=k){
                    h.put(arr[j],h.get(arr[j])>0?h.get(arr[j])-1:0);
                    if(h.get(arr[j])==0)h.remove(arr[j]);
                    j++;
                }
                ans.add(h.lastKey());
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length array of value and weight");
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println("Enter the length of the window ");
        int k=sc.nextInt();
        System.out.println(KsizeSubArrayMaximum.maxOfSubarrays(arr,k));
    }
}
