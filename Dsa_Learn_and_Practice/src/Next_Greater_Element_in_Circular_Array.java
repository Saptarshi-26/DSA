import java.util.*;
public class Next_Greater_Element_in_Circular_Array {
   static public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
       ArrayList<Integer> ans = new ArrayList<>();
       Stack<Integer> st = new Stack<>();
       Stack<Integer> index = new Stack<>();
      for(int i=0;i<arr.length;i++){
          int x=arr[i];
          if(!st.isEmpty()&&x>st.peek()){
              while(!st.isEmpty()&&st.peek()<x){
                  ans.set(index.peek(),x);
                  index.pop();
                  st.pop();
              }
              ans.add(-1);
              index.push(i);
              st.push(x);
          }
          else{
              ans.add(-1);
              st.push(x);
              index.push(i);
          }
      }
      if(!st.isEmpty()){
          for (int x : arr) {
              if (x > st.peek()) {
                  while (!st.isEmpty() && st.peek() <x) {
                      ans.set(index.peek(), x);
                      index.pop();
                      st.pop();
                  }
              }
              if (st.isEmpty()) break;

          }
      }
       return ans;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println(" Enter the length of the array ");
        int n=sc.nextInt();
        int[] arr =new int[n];
        System.out.println(" Enter the elements of the array ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println(nextLargerElement(arr));
    }
}
