package Leetcode;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        boolean answer;
        char[] w = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                answer = backtrack(board, i, j, 0, w, visited);
                if (answer) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean backtrack(char[][] board, int i, int j, int offset, char[] w, boolean[][] visited) {
        if (offset == w.length) {
            return true;
        }

        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) {
            return false;
        }

        if (visited[i][j]) {
            return false;
        }

        if (board[i][j] == w[offset]) {
            visited[i][j] = true;
            boolean res = backtrack(board, i, j + 1, offset + 1, w, visited)
                    || backtrack(board, i + 1, j, offset + 1, w, visited)
                    || backtrack(board, i - 1, j, offset + 1, w, visited)
                    || backtrack(board, i, j - 1, offset + 1, w, visited);
            visited[i][j] = false;

            return res;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
    }
}
