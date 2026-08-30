import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Fruit_Into_Baskets {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> fruits_count = new HashMap<>();
        int max = 0;
        int i = 0;
        int j = 0;
        while (i < fruits.length) {

            if (fruits_count.size() > 2) {
                fruits_count.put(fruits[j], fruits_count.get(fruits[j]) - 1);
                if (fruits_count.get(fruits[j]) == 0) {
                    fruits_count.remove(fruits[j]);
                }
                j++;
            } else {
                fruits_count.put(fruits[i], fruits_count.getOrDefault(fruits[i], 0) + 1);
                if (fruits_count.size() <= 2) {
                    max = Math.max(i + 1 - j, max);
                }
                i++;
            }
        }
        return max;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of fruits ");
        int[] fruits = new int[sc.nextInt()];
        IntStream.range(0, fruits.length).forEach(i -> fruits[i] = sc.nextInt());
        System.out.println(new Fruit_Into_Baskets().totalFruit(fruits));

    }
}
