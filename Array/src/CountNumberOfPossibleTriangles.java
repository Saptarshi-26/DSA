import java.util.*;
public class CountNumberOfPossibleTriangles {
    static int countTriangles(int arr[]) {
        // code here
        Arrays.sort(arr);
        int c=0;
        for(int i=0;i < arr.length-2;i++){
            for(int j=i+1;j<arr.length-1;j++){
                if(arr[i]==0||arr[j]==0)continue;
                int sum = arr[i]+arr[j];
                int k=j+1;
                int n=arr.length-1;
                int mid=(k+n)/2;
                while(k<=n){
                    if(arr[mid]<sum){
                        k=mid+1;
                    }
                    else if(arr[mid]>sum){
                        n=mid-1;
                    }
                    mid=(k+n)/2;
                }

                c+= Math.max((k - j-1), 0);

            }
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int[] arr = new int [n];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<arr.length;i++)arr[i]=sc.nextInt();
        System.out.println(countTriangles(arr));
    }
}
