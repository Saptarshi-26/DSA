import java.util.Scanner;
import java.util.stream.IntStream;

public class Word_Search {
    public boolean search(char[][] board, String word, int index, int i, int j, int[][] visited) {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) return false;
        if (word.charAt(index) != board[i][j]) return false;
        if (visited[i][j] != 0) return false;
        if (word.charAt(index) == board[i][j] && index == word.length() - 1) return true;
        visited[i][j] = 1;
        boolean ans = search(board, word, index + 1, i + 1, j, visited) ||
                search(board, word, index + 1, i - 1, j, visited) ||
                search(board, word, index + 1, i, j + 1, visited) ||
                search(board, word, index + 1, i, j - 1, visited);
        visited[i][j] = 0;
        return ans;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, word, 0, i, j, new int[board.length][board[0].length]))
                    return true;
            }
        }
        return false;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the row and column of the gird ");
        char[][] board = new char[sc.nextInt()][sc.nextInt()];
        System.out.println("enter the letters in the gird ");
        IntStream.range(0, board.length).
                forEach(i -> {
                    IntStream.range(0, board[i].length).
                            forEach(j -> {
                                board[i][j] = sc.next().charAt(0);
                            });
                });
        System.out.println(new Word_Search().exist(board, sc.next()));
    }
}
