import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Rate_in_Maze {
    public ArrayList<String> rat(int[][] maze, int i, int j, String s) {
        // code here
        if (i == -1 || j == -1 || i == maze.length || j == maze[0].length || maze[i][j] == 0) return new ArrayList<>();
        if (i == maze.length - 1 && j == maze[0].length - 1) return new ArrayList<>(List.of(s));

        maze[i][j] = 0;

        ArrayList<String> ans = rat(maze, i + 1, j, s + "D");

        ans.addAll(rat(maze, i, j - 1, s + "L"));
        ans.addAll(rat(maze, i, j + 1, s + "R"));
        ans.addAll(rat(maze, i - 1, j, s + "U"));

        maze[i][j] = 1;

        return ans;


    }

    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> ans = rat(maze, 0, 0, "");
        Collections.sort(ans);
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of row and column of maze");
        int[][] maze = new int[sc.nextInt()][sc.nextInt()];
        System.out.println("enter the maze");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

    }
}
