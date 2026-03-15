import java.text.DateFormatSymbols;
import java.util.Scanner;

public class Capacity_to_Ship_packages_in_D_Days {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int [] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i <arr.length; i++) {
            arr[i]= sc.nextInt();
        }
    }
}
