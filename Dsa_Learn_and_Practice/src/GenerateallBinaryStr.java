import java.util.*;
public class GenerateallBinaryStr { // gfg
    public static List<String> binarystr(String s , int n){
        List<String> a = new ArrayList<>();
        if(s.length()==n){
            a.add(s);
            return a ;
        }
        if(!s.isEmpty() &&s.charAt(s.length()-1)=='1'){
            a.addAll(binarystr((s+"0"),n));
            return a ;
        }
         a.addAll(binarystr(s+"1",n));
        a.addAll(binarystr(s+"0",n));
        return a ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number ");
        int n=sc.nextInt();
        List<String> a = new ArrayList<>(binarystr("",n));
        System.out.println(a);
    }
}
