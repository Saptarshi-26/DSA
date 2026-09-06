import java.util.Scanner;
import java.util.stream.IntStream;

public class Number_of_Islands {
    public void mark(char[][] grid, int i, int j, int[][] dp) {
        if (i >= dp.length || i < 0 || j < 0 || j >= dp[0].length) return;
        if (grid[i][j] == '0' || dp[i][j] == 1) return;
        dp[i][j] = 1;
        mark(grid, i + 1, j, dp);
        mark(grid, i, j + 1, dp);
        mark(grid, i - 1, j, dp);
        mark(grid, i, j - 1, dp);
    }

    public int numIslands(char[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dp[i][j] != 1 && grid[i][j] == '1') {
                    count++;
                    mark(grid, i, j, dp);
                }
            }
        }
        return count;

    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the dimension of the grid ");
        char[][] grid = new char[sc.nextInt()][sc.nextInt()];
        System.out.println("enter the values of the grid ");
        IntStream.range(0, grid.length).
                forEach(i -> IntStream.range(0, grid[i].length).
                        forEach(j -> grid[i][j] = sc.next().charAt(0)));
        System.out.println(new Number_of_Islands().numIslands(grid));
    }
}
