import java.util.*;
public class Possible_words_from_phone_Digits {
    public static ArrayList<String> words(int []arr, int i){
        String[] str ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz","*","0","#"};
        //   0  1    1    3       4    5    6      7     8     9
        ArrayList<String > s = new ArrayList<>();
        if(i==arr.length-1){
           for(int j=0;j<str[arr[i]].length();j++){
               s.add("" + str[arr[i]].charAt(j));
           }
            return s;
        }
        ArrayList<String > ss = new ArrayList<>(words(arr,i+1));
          for(int k=0;k<str[arr[i]].length();k++){
              for (String string : ss) {
                  s.add(str[arr[i]].charAt(k) + string);
              }
        }
        return s ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of phone digits ");
        int n= sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the digits of the phone number ");
        for (int i=0;i<n;i++)arr[i]=sc.nextInt();
       ArrayList<String> s = new ArrayList<>(words(arr,0));
        System.out.println(s);

    }
}
