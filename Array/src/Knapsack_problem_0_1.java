import java.util.*;
public class Knapsack_problem_0_1 {
   static  int knapsack(int x, int[] v, int[] wt) {
        // code here
           int max=0;
           String [] arr = new String[x+1];
           String [] a = new String[x+1];
           for(int i=wt.length-1;i>=0;i--){
               for(int j=0;j<=x;j++){
                   if(arr[j]!=null){
                       if(wt[i]+j<=x){
                           if(a[wt[i]+j]==null||(a[wt[i]+j]!=null&&Integer.parseInt(arr[j])+v[i]>Integer.parseInt(a[wt[i]+j])))
                               a[wt[i]+j]=Integer.toString(v[i]+Integer.parseInt(arr[j]));
                           if(Integer.parseInt(a[wt[i]+j])>max)max=Integer.parseInt(a[wt[i]+j]);
                       }
                   }

               }
               if(wt[i]<=x){
                   if(a[wt[i]]==null||(a[wt[i]]!=null&&Integer.parseInt(a[wt[i]])<v[i])) {
                       a[wt[i]] = Integer.toString(v[i]);
                       max = Math.max(Integer.parseInt(a[wt[i]]), max);
                   }
               }


               arr=a.clone();
           }
           return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length array of value and weight");
        int n=sc.nextInt();
        int[] v = new int[n];
        for(int i=0;i<n;i++)v[i]=sc.nextInt();
       // System.out.println("Enter the length of the array of weight");
       // n=sc.nextInt();
        int  wt[]=new int[n];
        for(int i=0;i<n;i++)wt[i]=sc.nextInt();
        System.out.println("Ënter the maximum weight ");
        int w = sc.nextInt();
        System.out.println(knapsack(w,v,wt));
    }

}
