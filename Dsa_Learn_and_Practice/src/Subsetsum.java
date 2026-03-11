import java.util.*;
public class Subsetsum {
    public static ArrayList<Integer> sumset(int arr[],int i,int sum ){
        ArrayList<Integer> a = new ArrayList<>();
        if(i>=arr.length){
            a.add(sum);
            return a;
        }
        a=(sumset(arr,i+1,sum+arr[i]));
        a.addAll(sumset(arr,i+1,sum));
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        a=(sumset(arr,0,0));
        Collections.sort(a);
        a.stream().distinct();
        System.out.println(a);

    }
}
