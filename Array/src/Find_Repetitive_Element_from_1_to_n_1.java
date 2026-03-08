import java.util.*;

public class Find_Repetitive_Element_from_1_to_n_1 {
    public static int findDuplicate(int[] arr) {
        // code here
        for (int i = 0; i < arr.length; ) {
            if (arr[i] != i + 1) {
                if (arr[arr[i] - 1] == arr[i]) return arr[i];
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            } else i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        System.out.println(findDuplicate(arr));
    }
}
