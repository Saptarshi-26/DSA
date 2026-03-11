import java.util.*;
public class SubsetII {
    public static ArrayList<ArrayList<Integer>> subset(ArrayList<Integer> ar,
                                                       int[] arr, int i){
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        if(i>=arr.length){
            a.add(ar);
            return a;
        }
        ArrayList<Integer> temp= new ArrayList<>(ar);
        temp.add(arr[i]);
     a=subset(temp,arr,i+1);
       ArrayList<Integer> temp2= new ArrayList<>(ar);
     a.addAll(subset(temp2,arr,i+1));
     return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array ");
        for (int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> a = new ArrayList<>(subset(new ArrayList<>(),arr,0));
       a=  new ArrayList<>(new HashSet<>(a));
        System.out.println(a);


    }
}
