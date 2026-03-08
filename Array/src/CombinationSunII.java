import java.lang.reflect.Array;
import java.util.*;
public class CombinationSunII {
    static ArrayList<ArrayList<Integer>> sum(int[] arr , int sum , int i, int x){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(i==arr.length||sum>x)return new ArrayList<>();
        if(sum+arr[i]==x){
            //return new ArrayList<>(List.of(new ArrayList<>(List.of(arr[i]))));
            ArrayList<Integer> a = new ArrayList<>();
            a.add(arr[i]);
            ans.add(a);

        }

        ArrayList<ArrayList<Integer>> temp = new ArrayList<>(sum(arr,sum+arr[i],i+1,x));
        ArrayList<ArrayList<Integer>> temp1 = new ArrayList<>(sum(arr,sum,i+1,x));

        if((temp.size()==1 && !temp.getFirst().isEmpty())||temp.size()>1){
            ans.addAll(temp);
            for(ArrayList<Integer> list : ans) {
                list.addFirst(arr[i]);
            }
        }
        if((temp1.size()==1 && !temp1.getFirst().isEmpty())||temp1.size()>1){
            ans.addAll(temp1);
        }


        return ans;

    }
    static ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int x) {
        // add your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(Objects.requireNonNull(sum(arr, 0, 0, x)));
        for(ArrayList<Integer> list : ans)
            Collections.sort(list);
        HashSet<ArrayList<Integer>> set = new HashSet<>(ans);
        return new ArrayList<>(set) ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(uniqueCombinations(arr,7));
    }
}
