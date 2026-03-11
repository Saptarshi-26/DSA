import java.util.*;
public class CountInversion {
   static int binarys(ArrayList<Integer> a , int k){
       if(a.size()==1){
           return 0;
       } else if (a.size()==2) {
           if(a.get(1)<k)return 1;
           else if(a.get(0)<k)return 0;
           else return 0;
       }
       int i=0;
        int j=a.size()-1;
        int mid=j/2;
        while(i<=j){
            if(a.get(mid)<k){
                i=mid+1;
            }
            else if(a.get(mid)>k||(mid>0&&(a.get(mid-1)==k&&a.get(mid)==k))){
                j=mid-1;
            }
            else return mid;
            mid=(i+j)/2;
        }
        return mid;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        ArrayList<Integer>  a = new ArrayList<>(List.of(arr[arr.length-1]));
      int c=0;
      for(int i=arr.length-2;i>=0;i--){
          int temp=binarys(a,arr[i]);
          if(a.get(temp)<arr[i])temp+=1;
          c+=temp;
        //  a.add(arr[i]);
          if(a.size()==1){
              if(arr[i]>a.get(0))a.add(arr[i]);
              else a.add(0,arr[i]);
              continue;
          }
          a.add(temp,arr[i]);
      }
        System.out.println(c);
    }
}
