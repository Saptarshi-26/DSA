import java.util.Scanner;

public class Minimum_Cost_path {
    public int min(int[][] grid, int[][] dp,int[][] loop, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (dp[i][j] != 0) return dp[i][j];
        int sum = Integer.MAX_VALUE;
        if (i + 1 < grid.length && loop[i+1][j]==0) {
            loop[i+1][j]=1;
            int temp = min(grid, dp, loop,i+1, j );
            sum = temp!=Integer.MAX_VALUE?grid[i][j] + temp : temp;
            loop[i+1][j]=0;
        }
        if (j + 1 < grid[0].length && loop[i][j+1]==0) {
            loop[i][j+1]=1;
            int temp = min(grid, dp, loop,i, j + 1);
            sum = Math.min(sum, temp!=Integer.MAX_VALUE?temp+grid[i][j]:temp);
            loop[i][j+1]=0;
        }
        if(i-1>=0 && loop[i-1][j]==0){
            loop[i-1][j]=1;
            int temp = min(grid, dp, loop,i-1, j );
            sum = Math.min(sum,temp!=Integer.MAX_VALUE?grid[i][j] + temp:temp);
            loop[i-1][j]=0;
        }
        if(j-1>=0 && loop[i][j-1]==0){
            loop[i][j-1]=1;
            int temp = min(grid, dp, loop,i, j -1);
            sum =Math.min(sum,temp!=Integer.MAX_VALUE?temp+ grid[i][j]:temp);
            loop[i][j-1]=0;
        }
        if(sum!=Integer.MAX_VALUE) {
           dp[i][j] = sum;
        }

        return sum;
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int[][] loop = new  int[grid.length][grid[0].length];
        loop[0][0]=1;
        int ans =min(grid, dp, loop,0, 0);
        for (int i =0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
        System.out.println("\t");

        return ans ;
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
        System.out.println(new Minimum_Cost_path().minPathSum(grid));
    }
}
