import java.util.*;
public class Maximum_Split_of_Increasing_Subsequence {
    public static int getMaxIncrements(List<Integer> a) {
        Collections.sort(a);
        int c=0;
        HashMap<Integer,Integer> h = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        for (Integer integer : a) {
            if (!h.containsKey(integer)) {
                h.put(integer, 1);
                arr.add(integer);
            } else h.put(integer, h.get(integer) + 1);
        }
        int c1 =h.get(arr.get(0));
        h.put(arr.get(0),0);
        int sum=0;
         for(int i=1;i<arr.size();i++){
            int t = h.get(arr.get(i));
            if(t<=c1){
                sum+=t;
                h.put(arr.get(i),0);
                c1=0;
            }
            else {
                sum+=c1;
                h.put(arr.get(i),t-c1);
                c1=t-c1;
            }
         }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> ar = Arrays.asList(1,1,2,2,4);
        System.out.println(getMaxIncrements(ar));
    }
}
