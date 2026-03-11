import java.util.*;
public class SplitArray_into_threee_eqaul_parts {
   static public List<Integer> findSplit(int[] arr) {
        // Return an array of possible answer, driver code will judge and return true or
        // false based on
        List<Integer> ans = new ArrayList<>(List.of(-1,-1));
        HashMap<Integer,Integer> h = new HashMap<>();
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(!h.containsKey(sum))h.put(sum,i);
        }
        if(sum%3==0){
            sum=sum/3;
            if(h.containsKey(2*sum)&&h.containsKey(sum)){
                ans.set(0,h.get(sum));
                int s=0;
                 int i=h.get(sum)+1;
                for( ;i<arr.length;i++){
                    s+=arr[i];
                    if(s>sum)break;
                }
                ans.set(1,i-1);
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();
        System.out.println(findSplit(arr));
    }
}
