import java.util.Scanner;

public class Stock_Buy_and_Sell_with_Cooldown {

    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[prices.length-1]=0;
        int ans =0;


        for (int i = prices.length-2;i>=0;i--){
            int max =0;
            for (int j=i+1;j<prices.length;j++){
                int temp = prices[j]-prices[i];
                max = Math.max(max,temp + ((j+2)<prices.length?dp[j+2]:0));
            }
            ans=Math.max(ans,max);
            dp[i]=ans;

        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] prices = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < prices.length; i++) {
            prices[i] = sc.nextInt();
        }
        System.out.println(new Stock_Buy_and_Sell_with_Cooldown().maxProfit(prices));

    }
}
