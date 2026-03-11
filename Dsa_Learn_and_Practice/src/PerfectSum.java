import java.util.*;
public class PerfectSum {
    static int sum(int[] arr, int i , HashMap<Integer,Integer> h, int sum){
        if(i==arr.length-1){
           if(arr[i]<=sum)h.put(arr[i],1);
           if(arr[i]==sum)return 1;
           else return 0;
        }
        int c=sum(arr,i+1,h,sum);
        HashMap<Integer,Integer> dummyMap= new HashMap<>(h);
        if(sum!=0&&h.containsKey(sum-arr[i]))c+=h.get(sum-arr[i]);
        if(sum!=0&&arr[i]==sum&&arr[i]!=0)c++;

        for(Map.Entry<Integer,Integer> x: h.entrySet()){
            if(x.getKey()==0)continue;;
            int temp=x.getKey()+arr[i];
            if(temp<=sum){
                dummyMap.put(temp,h.containsKey(temp)?h.get(temp)+x.getValue():x.getValue());
            }
        }
        int noOfZero=h.get(0);
        dummyMap.put(arr[i],dummyMap.containsKey(arr[i])?dummyMap.get(arr[i])+1+noOfZero:1+noOfZero);
        h.clear();
        h.putAll(dummyMap);
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int n= sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println("Enter the target sum");
        int sum= sc.nextInt();
        HashMap<Integer,Integer> h = new HashMap<>(Map.of(0,0));
        int ans=sum(arr,0,h,sum);
        ans=sum==0?h.get(0):ans;
        if(sum==0)ans++;
        System.out.println(ans);
    }
}
