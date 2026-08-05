import java.util.Scanner;
import java.util.stream.IntStream;

public class Best_Time_to_Buy_and_Sell_Stock_II {

    public int maxProfit(int[] pr) {
        int max = 0;
        int temp = 0;
        int last_buy = pr[0];
        int last_sell = pr[0];
        for (int x : pr) {
            if (x > last_sell) {
                temp = x - last_buy;
                last_sell = x;
            } else if (x < last_sell) {
                max += temp;
                temp = 0;
                last_buy = x;
                last_sell = x;
            }
        }
        max += temp;
        return max;

    }

    static void main() {
        System.out.println("enter the no of prices ");
        Scanner sc = new Scanner(System.in);
        int[] pr = new int[sc.nextInt()];
        IntStream.range(0, pr.length).forEach(index -> pr[index] = sc.nextInt());
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock_II().maxProfit(pr));

    }
}
