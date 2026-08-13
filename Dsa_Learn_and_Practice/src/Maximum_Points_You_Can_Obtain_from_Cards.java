import java.util.Scanner;
import java.util.stream.IntStream;

public class Maximum_Points_You_Can_Obtain_from_Cards {
    public int max(int[] cardPoints, int k, int i, int j, int[][][] dp) {
        if (i > j || k==0) return 0;
        if (i == j) return cardPoints[i];
        if(dp[i][j][k]!=0)return dp[i][j][k];
        return dp[i][j][k] = Math.max(max(cardPoints, k - 1, i, j - 1, dp) + cardPoints[j],
                Math.max( max(cardPoints, k - 1, i + 1, j, dp) + cardPoints[i],
                        k >= 2 ? max(cardPoints, k - 2, i + 1, j - 1, dp)
                                + cardPoints[i] + cardPoints[j] : 0));

    }

    public int maxScore(int[] cardPoints, int k) {
        return max(cardPoints, k, 0, cardPoints.length-1, new int[cardPoints.length][cardPoints.length][k + 1]);
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] cardPoints = new int[sc.nextInt()];
        System.out.println("enterv the points ");
        IntStream.range(0, cardPoints.length).forEach(i -> cardPoints[i] = sc.nextInt());
        System.out.println("enter the no of elemnts can be added ");
        int k = sc.nextInt();
        System.out.println(new Maximum_Points_You_Can_Obtain_from_Cards().maxScore(cardPoints, k));
    }
}
