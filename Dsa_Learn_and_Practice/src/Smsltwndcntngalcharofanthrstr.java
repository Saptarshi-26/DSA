import java.util.*;
public class Smsltwndcntngalcharofanthrstr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the stirng ");
        String s = sc.next();
        System.out.println("enter the second stirng ");
        String p= sc.next();
        HashMap<Character, Integer> h = new HashMap<>();
        HashMap<Character , Integer> hh = new HashMap<>();
        int c=0;  int count=0;
        for(int i=0;i<p.length();i++){
            char ch= p.charAt(i);
            if(!h.containsKey(ch)){ h.put(ch,1); count++; }
            else  h.put(ch,(h.get(ch))+1);
        }
        int i=0; int j=0;
       String b=s+s;
       while(i<s.length()){
           if(j==s.length()){
               if(c<count)break;
               else{
                   if(b.length()>s.substring(i,j).length()){
                       b=s.substring(i,j);
                   }
                   i++;
               }
               continue;
           }
          if(i==0&&j==0){
              for(;i<s.length()&&j<s.length()&&p.indexOf(s.charAt(i))==-1;i++,j++);
              if(i>=s.length())break;
              if(j>=s.length())continue;;
              hh.put(s.charAt(i),1); if(h.get(s.charAt(i))==hh.get(s.charAt(i)))c++; j++;
              if(c==count){
                  if(b.length()>s.substring(i,j).length()){
                      b=s.substring(i,j);
                  }
                  i++;
              }
              continue;
           }
          char ci=s.charAt(i);
          char cj=s.charAt(j);
          if(p.indexOf(cj)!=-1){
              if(!hh.containsKey(cj)){
                  hh.put(cj,1);
              }
              else hh.put(cj,hh.get(cj)+1);
              if(hh.get(cj)==h.get(cj))c++;
              if(c==count){
                  if(b.length()>s.substring(i,j+1).length()){
                      b=s.substring(i,j+1);
                  }
                  hh.put(ci,hh.get(ci)-1);
                  if(hh.get(ci)<h.get(ci))c--;
                  i++;
                  for(;i<s.length();i++){
                      if(p.indexOf(s.charAt(i))>=0){
                          if(hh.get(s.charAt(i))<=h.get(s.charAt(i))) {
                              if(c<count)
                              break;
                             else if(c==count){
                                  if(b.length()>s.substring(i,j+1).length()){
                                      b=s.substring(i,j+1);
                                  }
                                 hh.put(s.charAt(i),hh.get(s.charAt(i))-1);
                              c--; // break;
                          }
                          }
                          else{
                              hh.put(s.charAt(i),hh.get(s.charAt(i))-1);

                          }
                      }
                  }
                  j++;
              }
              else j++;
          }
          else j++;
       }

        System.out.println(b);
    }
}
