import java.util.*;
public class LongestPlaindrombyrearrangineing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string ");
        String s = sc.next();
        int arr[] = new int[5];
        String ans="";
        String ans1="";
        for(int i=0;i<s.length();i++){
            arr[(int)s.charAt(i)-97]++;
        }
        char c='z'+1;
        for(int i=0;i<5;){
            if(arr[i]%2!=0){
                arr[i]--;
                if(c==('z'+1)) {
                    c = (char) (i + 97);
                }
            }
            if(arr[i]>=2){
                ans+=(char)(i+97);
                ans1=(char)(i+97)+ans1;
                arr[i]-=2;
            }
            if(arr[i]==0)i++;
        }
        if(c!=('z'+1))ans+=c;

        ans+=ans1;
        System.out.println(ans);
    }
}
