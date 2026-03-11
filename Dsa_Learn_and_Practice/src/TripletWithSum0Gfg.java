import java.util.Scanner;
import java.util.*;
public class TripletWithSum0Gfg {
    public static List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<HashMap<Integer,ArrayList<Integer>>> a =
                new ArrayList<>
                        ((List.of(new HashMap<>(Map.of(arr[arr.length-1],
                                        new ArrayList<>(List.of(arr.length -1)))))));
        for(int i=arr.length-2;i>=0;i--){
           HashMap<Integer,ArrayList<Integer>> temp= new HashMap<>(a.get(0));
           ArrayList<Integer> t1;
           if(temp.containsKey(arr[i])){
             t1 = new ArrayList<>(temp.get(arr[i]));
             t1.add(0,i);
             temp.put(arr[i],t1);
             a.add(0,temp);

           }
           else{
               t1= new ArrayList<>(List.of(i));
               temp.put(arr[i],t1);
               a.add(0,temp);
           }
        }

        for(int i=0;i<arr.length-2;i++){
            for(int j=i+1;j<arr.length-1;j++){
                int t = -1*(arr[i]+arr[j]);
                if(a.get(j+1).containsKey(t)){
                    for(int x:a.get(j+1).get(t))ans.add(new ArrayList<>(List.of(i,j,x)));
                }
            }
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
        System.out.println(findTriplets(arr));
    }
}
