import java.util.*; //gfg
public class MkelemntsUnique {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println(" Enter the length of the array ");
        int n=sc.nextInt();
        int arr[] =new int[n];
        System.out.println(" Enter the elements of the array ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println();
        for (int x:arr) System.out.print(x+" ");
        int c=0;
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!h.containsKey(arr[i])){
                h.put(arr[i],arr[i]);
            }
            else{
                int t=h.get(arr[i]);
                while(h.containsKey(t)){
                    t++;
                    h.put(arr[i],t);
                }
                c+=(t-arr[i]);
                arr[i]=t;
                h.put(arr[i],t);
            }
        }
        System.out.println();
        for (int x:arr) System.out.print(x+" ");
        System.out.println();
        System.out.println(c);
    }
}
