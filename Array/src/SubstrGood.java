
import java.util.*;
public class SubstrGood {
    public static ArrayList<String> substr(String s){
        ArrayList <String>arr = new ArrayList<String>();
        arr.add(s);
        if(s.length()<2){
            return arr;
        }
        for(int i = 0; i<s.length(); i++){
           if(i==0)arr.add(s);
            String b=s.substring(0,i);
            if(i<s.length()-1) {
                b += s.substring(i + 1);
            }
               arr.addAll(substr(b));

        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string ");
        String s = sc.nextLine();
         ArrayList<String> arr = new ArrayList<String>();
         arr.addAll(substr(s));
         ArrayList<String> a = new ArrayList<String>();
         for(int i=0;i<arr.size();i++){
             if(a.contains(arr.get(i))==false){
                 a.add(arr.get(i));
             }
         }
       long count =0;
         for(int i=0;i<a.size();i++){
             int length= a.get(i).length()-1;
             char ch=a.get(i).charAt(length);
             int t=(int)ch-48;
             if(arr.get(i).charAt(0)!='0'&&t%2!=0){
                 count ++;
                 System.out.println(a.get(i));
             }
         }
        System.out.println(count);
    }
}