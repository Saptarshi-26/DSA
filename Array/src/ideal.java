import java.util.*;
public class ideal {
    static String idgernertae (HashMap < String, String > memeber_id){
        ArrayList<Character> ch = new ArrayList<>();
        for(char i='0';i<'9';i++,ch.add((char)(i)));
        String s="";
        for(int i=0;i<ch.size();i++)s+=ch.get(i);
        System.out.println(s);
        while(memeber_id.containsKey(s)){
                for(int j=0;j<ch.size()&&memeber_id.containsKey(s);j++) {
                    for(char i='0';i<'9'&&memeber_id.containsKey(s);i++){
                        s="";
                    ch.set(j, i);
                        for(int u=0;u<ch.size();u++)s+=ch.get(u);
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        HashMap<String ,String > h = new HashMap<>();
        h.put("123456789","abc");
        System.out.println(idgernertae (h));
    }
}
