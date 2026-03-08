import java.util.*;
public class Lis_retry {

    static int bin(ArrayList<Integer> ans , int x){
        if(ans.isEmpty())return -1;
        int i=0;
        int j=ans.size()-1 ;
        int mid=0;
        while(i<j){
            mid=(i+j)/2;
            if(ans.get(mid)<x)i=mid+1;
            else j=mid-1;
            mid=(i+j)/2;
        }
        if(ans.get(mid)>x)mid--;
        return mid;
    }


    static int lis(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        for(int x : arr){
            int i = bin(ans,x);
            if( ans.isEmpty()||i==ans.size()){ans.add(x);continue;}
          if(ans.get(i)!=x)ans.set(i,x);

        }
        return ans.size();
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int [] arr = new int [sc.nextInt()];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<arr.length;i++)arr[i]=sc.nextInt();
        System.out.println(lis(arr));
    }
}
