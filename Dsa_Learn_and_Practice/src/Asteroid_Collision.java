import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class Asteroid_Collision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (st.isEmpty()) {
                st.push(asteroids[i]);
            } else if (st.peek() >= 0 && asteroids[i] < 0) {
                if (st.peek() == Math.abs(asteroids[i])) {
                    st.pop();
                } else if (st.peek() < Math.abs(asteroids[i])) {
                    st.pop();
                    i--;
                }
            } else
                st.push(asteroids[i]);
        }
        int[] ans = new int[st.size()];
        for (int i = 0; i < ans.length; i++)
            ans[ans.length - 1 - i] = st.pop();
        return ans;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of asteroids ");
        int[] asteroids = new int[sc.nextInt()];
        IntStream.range(0, asteroids.length).forEach(i -> asteroids[i] = sc.nextInt());
        Arrays.stream(new Asteroid_Collision().asteroidCollision(asteroids)).
                forEach(System.out::println);

    }
}
