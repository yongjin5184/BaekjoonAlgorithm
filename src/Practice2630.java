import java.io.*;

public class Practice2630 {
    private static boolean[][] board;
    private static int white;
    private static int blue;

    public static void main(String[] args) throws Exception {
        /**
         * description : 백준 2630번 색종이 만들기 (쿼드트리)
         * solution : 1. 색종이를 4조각으로 나눈다.
         *            2. 탈출 조건은 아래와 같다.
         *               1)색종이의 크기가 1인 경우
         *               2)색종이의 색깔이 모두 같은 경우
     *                3. 이때, blue, white 색종이의 갯수를 구한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        int n = Integer.parseInt(br.readLine());

        board = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                board[i][j] = line[j].equals("1");
            }
        }

        divide(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void divide(int x, int y, int n) {
        if (n == 1) {
            countColor(board[x][y]);
            return;
        }

        if (sameColor(x, y, n)) {
            countColor(board[x][y]);
            return;
        }

        int newN = n / 2;
        divide(x, y, newN);
        divide(x + newN, y, newN);
        divide(x, y + newN, newN);
        divide(x + newN, y + newN, newN);
    }

    private static boolean sameColor(int x, int y, int n) {
        boolean color = board[x][y];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[x + i][y + j] != color) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void countColor(boolean boardValue) {
        if (boardValue) blue++;
        else white++;
    }
}

