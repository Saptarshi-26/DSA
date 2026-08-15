import java.util.Scanner;
import java.util.stream.IntStream;

public class Maximum_point_you_can_obtain_from_cards {
    public int maxScore(int[] cardPoints, int k) {
        // code here.
        int sum = 0;
        int i = 0;
        int j = cardPoints.length - 1;
        while (j >= cardPoints.length - k) {
            sum += cardPoints[j--];
        }
        j++;
        int max = sum;
        while (j < cardPoints.length) {
            sum += cardPoints[i++];
            sum -= cardPoints[j++];
            max = Math.max(max, sum);
        }
        return max;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of cards");
        int[] cardPoints = new int[sc.nextInt()];
        System.out.println("enter the cardPoints");
        IntStream.range(0, cardPoints.length).forEach(i -> cardPoints[i] = sc.nextInt());
        System.out.println("enter noof cards to be added fro both end ");
        System.out.println(new Maximum_point_you_can_obtain_from_cards().
                maxScore(cardPoints, sc.nextInt()));
    }
}
