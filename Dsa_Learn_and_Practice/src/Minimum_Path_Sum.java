import java.util.Scanner;

public class Minimum_Path_Sum {
    public int min(int[][] grid, int[][] dp, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (dp[i][j] != 0) return dp[i][j];
        int sum = Integer.MAX_VALUE;
        if (i + 1 < grid.length) sum = grid[i][j] + min(grid, dp, i + 1, j);
        if (j + 1 < grid[0].length) sum = Math.min(sum, grid[i][j] + min(grid, dp, i, j + 1));
        dp[i][j] = sum;
        return sum;
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return min(grid, dp, 0, 0);
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the dimensions of the grid ");
        int[][] grid = new int[sc.nextInt()][sc.nextInt()];
        System.out.println("enter the rows of the grid ");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++)
                grid[i][j] = sc.nextInt();
        }
        System.out.println(new Minimum_Path_Sum().minPathSum(grid));
    }
}
