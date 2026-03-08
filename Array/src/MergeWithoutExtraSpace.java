import java.util.*;
public class MergeWithoutExtraSpace {
   static void merge(int[] b, int a){
        int j=0;
        for(int i=1;i<b.length;i++){
            if(b[i]>a){
                b[j]=a;
                break;
            }
            else {
                b[j]=b[i];
                j++;
            }
        }
        if(j==b.length-1)b[j]=a;
    }
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the length  first array ");
            int n=sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++)a[i]=sc.nextInt();
            System.out.println("Enter the length second array ");
            n=sc.nextInt();
            int[] b = new int[n];
            for(int i=0;i<b.length;i++)b[i]= sc.nextInt();

        for(int i=0;i<a.length;i++){
            if(a[i]>b[0]){
                int t= a[i];
                a[i]=b[0];
                merge(b,t);
            }
        }
       for(int x:a){ System.out.print(x+" ");}
        for(int x:b) {System.out.print(x+" ");}

    }
}
