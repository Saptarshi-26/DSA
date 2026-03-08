import java.util.*;
public class PrintLevelsinsortedorder {
    public static ArrayList <ArrayList <Integer>> binTreeSortedLevels (int array[], int n)
    {
        // your code here
        int a=1;
        int t=1;
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(a==0){
                t=t*2;
                a=t;
                Collections.sort(arr);
               ArrayList<Integer> newarr=new ArrayList<>(arr);
                ans.add(newarr);
                arr.clear();
                arr.add(array[i]);
                a--;
            }
            else{
                arr.add(array[i]);
                a--;
            }
        }
        if(arr.size()>0){
            Collections.sort(arr);
            ArrayList<Integer> newarr=new ArrayList<>(arr);
            ans.add(newarr);
        }

        return ans ;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int array[]= new int[n];
        System.out.println("Enter the elements on the array as levels ");
        for (int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(binTreeSortedLevels(array,n));
        System.out.println(ans);

    }
}
