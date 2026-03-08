import java.util.*;
import java.util.stream.Collectors;

public class GenerateIPAddress {
   static public ArrayList<String> ip(String b , String s , int index , int div){
       if(index>=s.length()&&div>0){
           return new ArrayList<>();
       }
        if(div==0){
            if(index<s.length()){
                if((s.substring(index).length()<=9)&&((Integer.parseInt(s.substring(index))<=255&&s.charAt(index)!='0')||(index==s.length()-1)))
                    return new ArrayList<>(List.of(b+s.substring(index)));
                
            }
            return new ArrayList<>();
        }
       ArrayList<String> ans = new ArrayList<>(ip(b + s.charAt(index) + ".", s, index + 1, div - 1));
        if(index+1<s.length()&&s.charAt(index)!='0'){
            ans.addAll(ip(b+s.substring(index,index+2)+".",s,index+2,div-1));
        }
        String t = "";
        if(index+2<s.length()&&s.charAt(index)!='0')t+=s.substring(index,index+3);
        if(!t.isEmpty() &&Integer.parseInt(t)<=255){
            ans.addAll(ip(b+t+".",s,index+3,div-1));
        }

        return ans;

    }
    static public ArrayList<String> generateIp(String s) {
        // code here
          ArrayList<String > ans = new ArrayList<>(ip("",s,0,3));
          //ans.stream().filter(Objects::nonNull).toList();
          if(ans.isEmpty()){
              if(s.length()==4){
                  StringBuilder b= new StringBuilder();
                  for(int i=0;i<s.length();i++) b.append(s.charAt(i)).append(".");
                  b = new StringBuilder(b.substring(0, b.length() - 1));
                  ans.add(b.toString());
              }
          }
          return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string ");
        String s = sc.next();
        System.out.println(generateIp(s));
    }
}
