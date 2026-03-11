import java.util.*;
public class MaxmeetingdinOneRoom {
    public static ArrayList<Integer> maxMeetings(int n, int[] a, int[] arr) {
        // code here
        TreeMap<Integer,Integer> t = new TreeMap<>();
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!t.containsKey(arr[i])){
                t.put(arr[i],a[i]);
                h.put(arr[i],i+1);
            }
            else {
                int max=Math.max(t.get(arr[i]),a[i]);
                if(max>t.get(arr[i])){
                    t.put(arr[i],a[i]);
                    h.put(arr[i],i+1);
                }
            }
        }
        int c=0;
        int temp=-1;
        ArrayList<Integer> ans = new ArrayList<>();
        for( Integer Key : t.keySet()){
            if(t.get(Key)>temp){
                c++;
                temp=Key;
                ans.add(h.get(Key));
            }
        }
        Collections.sort(ans);
        return ans;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the starting and ending  time array ");
        int n=sc.nextInt();
        int a[]= new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        int arr[]= new int[n];
        for (int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println(maxMeetings(n,a,arr));



    }
}
