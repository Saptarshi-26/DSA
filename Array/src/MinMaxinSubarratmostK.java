import java.util.*;
public class MinMaxinSubarratmostK {
    // sum of minimum and maximum elements of all sub array which is at most size of k
   static int  minmaxSub(ArrayList<Integer> arr , ArrayList<Integer>a, int[] minmax, int k){
if(arr.size()==1){
    minmax= new int[2];
    minmax[0]=minmax[1]=arr.getFirst();
}
       if(a.isEmpty()){
           if(arr.isEmpty())return 0;
          // System.out.println(arr);
         return minmax[0]+minmax[1];
       }
       int sum=0;
       
       ArrayList<Integer> a1 = new ArrayList<>(arr);
       ArrayList<Integer> a2 = new ArrayList<>(a);

       int temp=a2.getFirst();
       a2.removeFirst();

     if(a1.size()<=k) sum+=(minmaxSub(a1,a2,minmax,k));
       a1= new ArrayList<>(arr);
       int min=minmax[0];
       int max=minmax[1];

       minmax= new int[2];

       minmax[0]=min;
       minmax[1]=max;

       if(minmax[0]>temp)minmax[0]=temp;
       else if(minmax[1]<temp)minmax[1]=temp;

       a1.add(temp);

     if(a1.size()<=k) sum+=(minmaxSub(a1,a2, minmax,k));
      return sum ;

   }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc .nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<n;i++)array[i]=sc.nextInt();
        System.out.println("Enter the maximum size of sub array ");
        int k=sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int x:array)arr.add(x);
        int sum=minmaxSub(new ArrayList<>(), arr,new int[2] ,k);
        System.out.println(sum);

    }
}
