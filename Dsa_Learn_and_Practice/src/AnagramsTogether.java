import java.util.*;
public class AnagramsTogether {
    public static Boolean isanagram(String a , String b){ // gfg
        int[] arr =  new int[257];
        for(int i=0;i<a.length();i++)arr[(int)a.charAt(i)]++;
        for(int i=0;i<a.length();i++)arr[(int)b.charAt(i)]--;
        for(int i=0;i<257;i++)if(arr[i]!=0)return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of strings that will be provided ");
        int n= sc.nextInt();
        System.out.println("Enter the strings ");
        String[] arr = new String[n];
        for (int i=0;i<n;i++)arr[i]=sc.next();
        ArrayList<ArrayList<String >> ans = new ArrayList<>();
        if(n==0)ans.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            ArrayList<String >a = new ArrayList<>();
            a.add(arr[i]);
            if(!arr[i].isEmpty()){
                for(int j=i+1;j<n;j++){
                    if(arr[j].length()==arr[i].length()){
                       if(isanagram(arr[j], arr[i])){
                           a.add(arr[j]);
                           arr[j]="";
                       }
                    }
                }
                ans.add(a);
            }
        }
        System.out.println(ans);

    }
}
