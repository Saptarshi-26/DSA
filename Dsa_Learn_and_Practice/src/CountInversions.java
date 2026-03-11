import java.util.*;
public class CountInversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int[] arr = new int [n];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<arr.length;i++)arr[i]=sc.nextInt();
        int c=0;
       LinkedList<Integer> a = new LinkedList<>();
        a.add(arr[arr.length-1]);
        for(int i=arr.length-2;i>=0;i--){
            int j=0;
            for(;j<a.size();j++){
                if(a.get(j)>=arr[i]){
                    a.add(j, arr[i]);
                    break;
                }
                else if (a.get(j)<arr[i]) c++;

            }
            if(j==a.size())a.add(arr[i]);
        }
        System.out.println(c);
    }
}
