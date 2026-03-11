import java.util.*;
public class PermuatationStr {
    public static ArrayList<String> permute(String s) {
        ArrayList<String> arr = new ArrayList<>();
        if(s.length()==1){
            arr.add(s);
            return arr;
        }
        ArrayList<String > a = new ArrayList<>();
        char ch[] = new char[s.length()];
        ch=s.toCharArray();
        for(int i=0;i<s.length();){
            String b= new String(ch);
            a.addAll(permute(b.substring(1)));
            for(int j=0;j<a.size();j++){
                arr.add(b.charAt(0)+a.get(j));
            }
            a= new ArrayList<>();
            i++;
            if(i==s.length()){
                return arr;
            }
            char tem= ch[0];
            ch[0]=ch[i];
            ch[i]=tem;



        }
        return arr;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string ");
        String s = sc.next();
        ArrayList<String> arr = new ArrayList<>(permute(s));
        Collections.sort(arr);
        System.out.println(arr);
    }
}
