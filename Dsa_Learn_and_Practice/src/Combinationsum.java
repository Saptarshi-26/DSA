import java.lang.reflect.Array;
import java.util.*;
public class Combinationsum {
    static ArrayList<ArrayList<Integer>> cobnination (ArrayList<Integer> arr ,  ArrayList<Integer> ar,
                                                      int i,int x, int sum
                                                      )
    {
        ArrayList<ArrayList<Integer >> a = new ArrayList<>();
        if(sum==x){
            ArrayList<Integer> temp= new ArrayList<>();
            temp.addAll(ar);
            a.add(temp);
            return a;
        }


        for(;i< arr.size();i++) {
            if(sum + arr.get(i) > x) continue;
            sum = sum + arr.get(i);
            ar.add(arr.get(i));
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>(cobnination(arr, ar, i, x, sum));
            sum -= arr.get(i);
            ar.removeLast();
            if (!temp.isEmpty()) {
                a.addAll(temp);
            }

        }
        return a ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 'n' to stop giving inputs ");
        System.out.println("Enter the elements ");
        String s= sc.next();
        ArrayList<Integer> arr = new ArrayList<>();
        while(!s.equalsIgnoreCase("n")){
            arr.add(Integer.parseInt(s));
            s= sc.next();
        }
        System.out.println("Enter the target number ");
        int x = sc.nextInt();
        Collections.sort(arr);
        arr.removeIf(n ->n ==0);
        arr = new ArrayList<>(new HashSet<>(arr));
        ArrayList<Integer> ar = new ArrayList<>();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>(cobnination(arr,new ArrayList<>(),0,x,0));

        for(ArrayList<Integer> list: a){
            System.out.println(list);
            System.out.println();
        }
    }


}
