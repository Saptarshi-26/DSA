import java.util.*;
public class FirstandLastOccurence {
  static  ArrayList<Integer> find(int[] arr, int x) {
        // code here
      int i=0;
      int j=arr.length-1;
      int mid=j/2;
      while(i<=j){
          if(arr[mid]>x||(mid>0&&arr[mid]==x&&arr[mid-1]==x)){
              j=mid-1;
          }
          else if(arr[mid]<x){
              i=mid+1;
          }
          else break;
          mid=(i+j)/2;
      }
      if(arr[mid]!=x)return new ArrayList<>(List.of(-1,-1));
      ArrayList<Integer> ans = new ArrayList<>();
      ans.add(mid);
      i=0;
      j=arr.length-1;
      mid=j/2;
      while(i<=j){
          if(arr[mid]>x){
              j=mid-1;
          }
          else if(arr[mid]<x||(mid<arr.length-1&&arr[mid]==x&&arr[mid+1]==x)){
              i=mid+1;
          }
          else break;
          mid=(i+j)/2;
      }
      if(arr[mid]!=x)return new ArrayList<>(List.of(-1,-1));
      ans.add(mid);
      return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println("Enter the element of which the occurrence is to be found ");
        int x=sc.nextInt();
        System.out.println(find(arr,x));
    }
}
