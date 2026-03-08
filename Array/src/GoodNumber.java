import java.util.*;
public class GoodNumber { // gfg weekly contest
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n = sc.nextInt();
        int[] arr= new int[n];
        System.out.println("Enter the elements of the array ");
        for (int i=0;i<arr.length;i++)arr[i]=sc.nextInt();
        System.out.println("Enter the k integer ");
        int k=sc.nextInt();
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!h.containsKey(arr[i]))h.put(arr[i],1);
            else h.put(arr[i],h.get(arr[i])+1);
        }
        int c=0;
        for(int i=0;i<arr.length;i++){
            if(h.get(arr[i])==0)continue;
            if(!h.containsKey(arr[i]^k))c++;
            else if(h.containsKey(arr[i]^k)){
                if(h.get(arr[i]^k)==0)c++;
                else {
                    if(arr[i]==(arr[i]^k)){
                        if(h.get(arr[i])>=2){
                            h.put(arr[i],h.get(arr[i])-2);
                        }
                        else{
                            c++;
                            h.put(arr[i],h.get(arr[i])-1);

                        }
                        continue;
                    }
                    h.put(arr[i],h.get(arr[i])-1);
                    h.put(arr[i]^k,h.get(arr[i]^k)-1);
                }
            }
        }
        System.out.println(c);

    }
}
