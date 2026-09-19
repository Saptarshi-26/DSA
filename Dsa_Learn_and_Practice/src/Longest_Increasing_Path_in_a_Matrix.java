import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Longest_Increasing_Path_in_a_Matrix {
    public int longestPath(int[][] matrix , int i , int j , int[][]dp , int prev) {

        if(i>=matrix.length||j>=matrix[0].length || i<0 || j<0 )return 0;

        if(matrix[i][j]<=prev) return 0;

        if(dp[i][j]!=0) return dp[i][j];

        int maxPath=0;

        maxPath=Math.max(maxPath,
                Math.max(longestPath(matrix, i+1,j,dp,matrix[i][j]),
                Math.max(longestPath(matrix,i-1,j,dp,matrix[i][j]),
                        Math.max(longestPath(matrix,i,j+1,dp,matrix[i][j]),
                                longestPath(matrix,i,j-1,dp,matrix[i][j])))));

        return dp[i][j]=maxPath+1;

    }
    public int longestIncreasingPath(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];

        int masPath=0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                masPath=Math.max(masPath,longestPath(matrix,i,j,dp,matrix[i][j]-1));
            }
        }
        return masPath;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of rows ");
        int n = sc.nextInt();
        System.out.println("enter the no of columns ");
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        System.out.println("enter the elements of the array ");

        IntStream.range(0,matrix.length).
                forEach(i-> IntStream.range(0,matrix[0].length).
                        forEach(j-> matrix[i][j]= sc.nextInt()));

        System.out.println(new Longest_Increasing_Path_in_a_Matrix().longestIncreasingPath(matrix));

    }
}
